package com.home.deserialization;

public class Request {
//{"request":{"mbean":"com.textura.link:name=ClientMonitor","attribute":"Properties","type":"read"},"value":{},"timestamp":1452095556,"status":200}
	
		private String mbean;
		private String attribute;
		private String type;

		public String getMbean() {
			return mbean;
		}
		public void setMbean(String mbean) {
			this.mbean = mbean;
		}
		public String getAttribute() {
			return attribute;
		}
		public void setAttribute(String attribute) {
			this.attribute = attribute;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}

}
