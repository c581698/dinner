Ext.define("com.tp.view.AttachmentForm", {
			extend : "com.tp.app.BaseForm",

			constructor : function() {
				var me = this;

				me.items = [{
							name : "fileId",
							xtype : 'numberfield',
							allowBlank : false,
							fieldLabel : "记录ID，主键",
							tooltip : "记录ID，主键"
						}, {
							name : "fileName",
							xtype : 'textfield',
							maxLength : 127.5,
							allowBlank : false,
							fieldLabel : "文件原始名",
							tooltip : "文件原始名"
						}, {
							name : "fileOutName",
							xtype : 'textfield',
							maxLength : 127.5,
							allowBlank : false,
							fieldLabel : "附件系统生成的名称",
							tooltip : "附件系统生成的名称"
						}, {
							name : "fileExt",
							xtype : 'textfield',
							maxLength : 5,
							allowBlank : true,
							fieldLabel : "附件扩展名",
							tooltip : "附件扩展名"
						}, {
							name : "filePath",
							xtype : 'textfield',
							maxLength : 127.5,
							allowBlank : false,
							fieldLabel : "文件路径",
							tooltip : "文件路径"
						}, {
							name : "attachmentType",
							xtype : 'numberfield',
							allowBlank : false,
							fieldLabel : "附件所属类型",
							tooltip : "附件所属类型"
						}, {
							name : "refId",
							xtype : 'numberfield',
							allowBlank : false,
							fieldLabel : "附件所属对象编号",
							tooltip : "附件所属对象编号"
						}, {
							name : "createDate",
							xtype : 'datefield',
							allowBlank : true,
							fieldLabel : "附件上传时间",
							tooltip : "附件上传时间"
						}, {
							name : "creator",
							xtype : 'numberfield',
							allowBlank : true,
							fieldLabel : "附件上传人编号person_id",
							tooltip : "附件上传人编号person_id"
						}];

				me.callParent(arguments);
			}
		});
