Ext.define("com.tp.store.Attachment", {
			extend : "com.tp.app.BaseStore",
			requires : ["com.tp.model.Attachment"],
			model : "com.tp.model.Attachment",
			proxy : {
				type : 'ajax',
				url : APP_CONTEXT_PATH + '/listAttachment.action'
			}
		});