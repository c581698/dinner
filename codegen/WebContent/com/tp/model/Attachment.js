Ext.define("com.tp.model.Attachment", {
			extend : "com.tp.app.BaseModel",
			fields : ["fileId", "fileName", "fileOutName", "fileExt",
					"filePath", "attachmentType", "refId", "createDate",
					"creator"]
		});