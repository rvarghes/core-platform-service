package com.kcdata.abe.bapi;
public class Z_Get_Mat_Bat_Availability_Fault extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1322472203982L) ;

    private  Z_Get_Mat_Bat_Availability_Fault.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.XSDL_COMPLEX_TYPE, "urn:sap-com:document:sap:rfc:functions", "Z_GET_MAT_BAT_AVAILABILITY.Exception", 4, 0, com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Fault.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_XML, "Z_GET_MAT_BAT_AVAILABILITY", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Material/S.Loc/Batch  Availability</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZMMM</ifr:package><ifr:akhNode /><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "Name", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Name", com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Fault.NameType.class, null, new java.lang.String[][]{{"enumeration", "NO_MAT_BAT"}}, null, 0, 0, 0, -1, -1, -1, -1, 0, null);
        descriptorSetElementProperties(descriptor, 1, "Text", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Text", java.lang.String.class, null, new java.lang.String[][]{}, null, 0, 0, 0, -1, -1, -1, -1, 0, null);
        descriptorSetElementProperties(descriptor, 2, "Message", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Message", MessageType.class, new MessageType(), new java.lang.String[][]{}, null, 0, 0, 0, -1, -1, -1, -1, 0, null);
        descriptorSetElementProperties(descriptor, 3, "Attributes", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Attributes", AttributesType.class, new AttributesType(), new java.lang.String[][]{}, null, 0, 0, 0, -1, -1, -1, -1, 0, null);
        staticDescriptor = descriptor;
    }
    public  Z_Get_Mat_Bat_Availability_Fault () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_XML);
        
    }

    protected  Z_Get_Mat_Bat_Availability_Fault (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setText(java.lang.String Text) {
        baseTypeData().setElementValue(1, Text);
    }

    public void setAttributes(AttributesType Attributes) {
        baseTypeData().setElementValue(3, Attributes);
    }

    public void setName(com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Fault.NameType Name) {
        baseTypeData().setElementValue(0, Name);
    }

    public MetaData metadataZ_Get_Mat_Bat_Availability_Fault() {
        return metadata;
    }

    public java.lang.String getText() {
        return (java.lang.String)baseTypeData().getElementValueAsString(1);
    }

    public MessageType getMessage() {
        return (MessageType)baseTypeData().getElementValue(2);
    }

    public com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Fault.NameType getName() {
        return (com.kcdata.abe.bapi.Z_Get_Mat_Bat_Availability_Fault.NameType)baseTypeData().getElementValue(0);
    }

    public void setMessage(MessageType Message) {
        baseTypeData().setElementValue(2, Message);
    }

    public AttributesType getAttributes() {
        return (AttributesType)baseTypeData().getElementValue(3);
    }

    public static class AttributesType extends com.sap.aii.proxy.framework.core.AbstractType{
    
        private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;
    
        private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1322472203982L) ;
    
        private  AttributesType.MetaData metadata = new MetaData(this) ;
    
        static {
            com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.XSDL_COMPLEX_TYPE, "urn:sap-com:document:sap:rfc:functions", "", 4, 0, AttributesType.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_XML, null, -1, -1, -1, null);
            descriptorSetElementProperties(descriptor, 0, "V1", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "V1", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, null, 0, 0, 0, -1, -1, -1, -1, 0, null);
            descriptorSetElementProperties(descriptor, 1, "V2", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "V2", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, null, 0, 0, 0, -1, -1, -1, -1, 0, null);
            descriptorSetElementProperties(descriptor, 2, "V3", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "V3", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, null, 0, 0, 0, -1, -1, -1, -1, 0, null);
            descriptorSetElementProperties(descriptor, 3, "V4", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "V4", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "50"}}, null, 0, 0, 0, -1, -1, -1, -1, 0, null);
            staticDescriptor = descriptor;
        }
        public  AttributesType () {
            super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_XML);
            
        }
    
        protected  AttributesType (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
            super(descriptor, staticGenerationInfo, connectionType);
        }
    
        public void setV3(java.lang.String V3) {
            baseTypeData().setElementValue(2, V3);
        }
    
        public void setV2(java.lang.String V2) {
            baseTypeData().setElementValue(1, V2);
        }
    
        public void setV1(java.lang.String V1) {
            baseTypeData().setElementValue(0, V1);
        }
    
        public java.lang.String getV4() {
            return (java.lang.String)baseTypeData().getElementValueAsString(3);
        }
    
        public java.lang.String getV3() {
            return (java.lang.String)baseTypeData().getElementValueAsString(2);
        }
    
        public java.lang.String getV2() {
            return (java.lang.String)baseTypeData().getElementValueAsString(1);
        }
    
        public java.lang.String getV1() {
            return (java.lang.String)baseTypeData().getElementValueAsString(0);
        }
    
        public MetaData metadataAttributesType() {
            return metadata;
        }
    
        public void setV4(java.lang.String V4) {
            baseTypeData().setElementValue(3, V4);
        }
    
        public static class MetaData implements java.io.Serializable {
        
            private  AttributesType parent ;
        
            private  static final long serialVersionUID = -386313361L ;
        
            protected  MetaData (AttributesType parent) {
                this.parent = parent;
                
            }
        
            public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
                return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
            }
        
            public com.sap.aii.proxy.framework.core.ElementMetaData getV4() {
                return parent.baseTypeMetaData().getElement(3);
            }
        
            public com.sap.aii.proxy.framework.core.ElementMetaData getV3() {
                return parent.baseTypeMetaData().getElement(2);
            }
        
            public com.sap.aii.proxy.framework.core.ElementMetaData getV2() {
                return parent.baseTypeMetaData().getElement(1);
            }
        
            public com.sap.aii.proxy.framework.core.ElementMetaData getV1() {
                return parent.baseTypeMetaData().getElement(0);
            }
        
        }
    
    }

    public static class MessageType extends com.sap.aii.proxy.framework.core.AbstractType{
    
        private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;
    
        private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1322472203982L) ;
    
        private  MessageType.MetaData metadata = new MetaData(this) ;
    
        static {
            com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.XSDL_COMPLEX_TYPE, "urn:sap-com:document:sap:rfc:functions", "", 2, 0, MessageType.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_XML, null, -1, -1, -1, null);
            descriptorSetElementProperties(descriptor, 0, "ID", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Id", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "20"}}, null, 0, 0, 0, -1, -1, -1, -1, 0, null);
            descriptorSetElementProperties(descriptor, 1, "Number", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Number", java.lang.String.class, null, new java.lang.String[][]{{"pattern", "\\d+"}, {"maxLength", "3"}}, null, 0, 0, 0, -1, -1, -1, -1, 0, null);
            staticDescriptor = descriptor;
        }
        public  MessageType () {
            super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_XML);
            
        }
    
        protected  MessageType (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
            super(descriptor, staticGenerationInfo, connectionType);
        }
    
        public void setId(java.lang.String Id) {
            baseTypeData().setElementValue(0, Id);
        }
    
        public void setNumber(java.lang.String Number) {
            baseTypeData().setElementValue(1, Number);
        }
    
        public MetaData metadataMessageType() {
            return metadata;
        }
    
        public java.lang.String getId() {
            return (java.lang.String)baseTypeData().getElementValueAsString(0);
        }
    
        public java.lang.String getNumber() {
            return (java.lang.String)baseTypeData().getElementValueAsString(1);
        }
    
        public static class MetaData implements java.io.Serializable {
        
            private  MessageType parent ;
        
            private  static final long serialVersionUID = -386313361L ;
        
            protected  MetaData (MessageType parent) {
                this.parent = parent;
                
            }
        
            public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
                return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
            }
        
            public com.sap.aii.proxy.framework.core.ElementMetaData getId() {
                return parent.baseTypeMetaData().getElement(0);
            }
        
            public com.sap.aii.proxy.framework.core.ElementMetaData getNumber() {
                return parent.baseTypeMetaData().getElement(1);
            }
        
        }
    
    }

    public static class NameType extends com.sap.aii.proxy.framework.core.EnumerationType implements java.io.Serializable {
    
        private  static final long serialVersionUID = 1905239173L ;
    
        private  final java.lang.String name ;
    
        public  static final java.lang.String _NO_MAT_BAT = "NO_MAT_BAT" ;
    
        /** instance for value NO_MAT_BAT */
        public  static final NameType NO_MAT_BAT = new NameType(_NO_MAT_BAT) ;
    
        private  NameType (java.lang.String name) {
            this.name = name;
        }
    
        public static NameType fromString(java.lang.String name) {
            if (name.equals("NO_MAT_BAT")){return NO_MAT_BAT;};
             throw createIllegalArgumentException(name);
        }
    
        public static NameType fromValue(java.lang.String name) {
            if (name.equals(_NO_MAT_BAT)){return NO_MAT_BAT;};
             throw createIllegalArgumentException(name);
        }
    
        public java.lang.String toString() {
            return java.lang.String.valueOf(name);
        }
    
        public java.lang.String getValue() {
            return name;
        }
    
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Get_Mat_Bat_Availability_Fault parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Get_Mat_Bat_Availability_Fault parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.ElementMetaData getText() {
            return parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.ElementMetaData getMessage() {
            return parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.ElementMetaData getName() {
            return parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.ElementMetaData getAttributes() {
            return parent.baseTypeMetaData().getElement(3);
        }
    
    }

}
