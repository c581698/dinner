package com.dh.generate


import java.beans.java_awt_BorderLayout_PersistenceDelegate;
import java.lang.ref.ReferenceQueue.Null;
import java.sql.DriverManager;
import java.sql.ResultSet;

import freemarker.template.Configuration
import freemarker.template.DefaultObjectWrapper
import freemarker.template.Template
import groovy.sql.ResultSetMetaDataWrapper
import groovy.sql.Sql

class GenEngine {
	def static Map map = new HashMap();
	def static Sql sql;
	def static srcPath;
	def static webPath;
	def static basePath;
	def static packageName;
	def static pk = new HashMap();

	static void main(arg){
		init();
		initPK();

		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(basePath+"/src/main/resources/ftl"));
		cfg.setObjectWrapper(new DefaultObjectWrapper());

		Template model = cfg.getTemplate("Model.ftl");
		Template store = cfg.getTemplate("Store.ftl");
		Template form = cfg.getTemplate("Form.ftl");
		Template view = cfg.getTemplate("Grid.ftl");
		Template entity = cfg.getTemplate("Entity.ftl");
		Template dao = cfg.getTemplate("Dao.ftl");
		Template action = cfg.getTemplate("Action.ftl");

		if(map.size() > 0 && null != sql){
			def conn = sql.createConnection();

			def md = conn.getMetaData();

			def rs;

			map.each {key,value ->
				rs = md.getColumns(null, "BUDGET", key.toUpperCase(), "%");
				def namespace = value.indexOf('.')==-1?[value]:value.split(/\./);
				def tb = [name:namespace[-1]];
				tb.columns = [];
				tb.tableName = key.toUpperCase();
				tb.packageName = packageName;

				tb.filePath = namespace.size() == 1?"": value.substring(0,value.lastIndexOf("."));
				while(rs.next()){
					tb.pk = toUpper(pk[tb.tableName]);
					tb.pkName = pk[tb.tableName];

					tb.columns << [
						"name":toUpper(rs.getString("COLUMN_NAME")),
						"columnName":rs.getString("COLUMN_NAME"),
						"type":rs.getInt("DATA_TYPE"),
						"size":rs.getInt("COLUMN_SIZE"),
						"precision":rs.getInt("DECIMAL_DIGITS"),
						"allowBlank":rs.getInt("NULLABLE"),
						"desc":rs.getString("REMARKS"),
						"default":rs.getString("COLUMN_DEF")
					];
				}

				def path = webPath+"/"+packageName.replaceAll(".","/")+"/model/"+tb.filePath;

				File file = new File(path);
				file.mkdirs();

				model.process(tb, new FileWriter(file.getAbsolutePath()+"/"+tb.name+".js"));

				file = new File(path.replace("model", "store"));
				file.mkdirs();

				store.process(tb, new FileWriter(file.getAbsolutePath()+"/"+tb.name+".js"));

				file = new File(file.getAbsolutePath().replace("store", "view"));
				file.mkdirs();

				form.process(tb, new FileWriter(file.getAbsolutePath()+"/"+tb.name+"Form.js"));

				view.process(tb, new FileWriter(file.getAbsolutePath()+"/"+tb.name+"View.js"));

				file = new File(srcPath+"/"+packageName.replace(".","/")+"/entity/"+tb.filePath);
				file.mkdirs();

				entity.process(tb, new FileWriter(file.getAbsolutePath()+"/"+tb.name+".java"));

				file = new File(srcPath+"/"+packageName.replace(".","/")+"/dao/"+tb.filePath);
				file.mkdirs();

				dao.process(tb, new FileWriter(file.getAbsolutePath()+"/"+tb.name+"Dao.java"));

				file = new File(srcPath+"/"+packageName.replace(".","/")+"/action/"+tb.filePath);
				file.mkdirs();

				action.process(tb, new FileWriter(file.getAbsolutePath()+"/"+tb.name+"Action.java"));
			}
		}
	}

	static String toUpper(name){
		name = name.toLowerCase();

		if(name.indexOf("_") != -1){
			def temp="";

			name.split("_").each {
				temp += it.replaceFirst(it.charAt(0).toString(), it.charAt(0).toUpperCase().toString());
			}

			return temp.replaceFirst(temp.charAt(0).toString(), temp.charAt(0).toLowerCase().toString());
		}

		return name;
	}

	static void init(){
		basePath = System.getProperty("user.dir");
		Properties props = new Properties();
		props.load(new FileInputStream(basePath+"/src/main/resources/gen.properties"));

		packageName = props.getProperty("package")!=null?props.getProperty("package"):"com/doit";

		srcPath =basePath + "/" + (props.getProperty("src")!=null?props.getProperty("src"):"src");

		webPath =basePath + "/" +  (props.getProperty("web")!=null?props.getProperty("web"):"web");

		Properties dbProp = new Properties();
		dbProp.setProperty("user", props.getProperty("user"));
		dbProp.setProperty("password", props.getProperty("password"));
		dbProp.setProperty("remarksReporting","true");

		sql = Sql.newInstance(props.getProperty("url"), dbProp, props.getProperty("driver"));

		props = new Properties();
		props.load(new FileInputStream(basePath+"/src/main/resources/table.properties"));

		props.each {key,value ->
			map[key]=value;
		}
	}

	static void initPK (){
		sql.eachRow(
				"SELECT CU.*\n" +
				"  FROM USER_CONS_COLUMNS CU, USER_CONSTRAINTS AU\n" +
				" WHERE CU.CONSTRAINT_NAME = AU.CONSTRAINT_NAME\n" +
				"   AND AU.CONSTRAINT_TYPE = 'P'\n" +
				"   AND CU.POSITION = 1") {row ->

					pk[row[2]] = row[3];
				}
	}
}
