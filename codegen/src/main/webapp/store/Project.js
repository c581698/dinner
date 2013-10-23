Ext.define("com.tp.store.Project",{
extend : "com.tp.app.BaseStore",
requires : ["com.tp.model.Project"],
model : "com.tp.model.Project",
proxy : {
type : 'ajax',
url : APP_CONTEXT_PATH+'/listProject.action'
}
});