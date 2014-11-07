package com.kcdata.abe.bapi;
public class Z_Api_Resort_List_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1245945380218L) ;

    private  Z_Api_Resort_List_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_RESORT_LIST.Output", 3, 0, com.kcdata.abe.bapi.Z_Api_Resort_List_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_RESORT_LIST", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">List possible resorts destination wise</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "RETURN", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:BAPIRETURN", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Return", com.kcdata.abe.bapi.BapireturnType.class, new com.kcdata.abe.bapi.BapireturnType(), new java.lang.String[][]{}, "RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"RETURN\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"BAPIRETURN\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRETURN\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "RESORTS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Resorts", com.kcdata.abe.bapi.util.ZshcharType_List.class, new com.kcdata.abe.bapi.ZshcharType(), new java.lang.String[][]{}, "RESORTS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"RESORTS\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZSHCHAR\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZSHCHAR\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "HOTELS_NAME", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Hotels_Name", com.kcdata.abe.bapi.util.ZshcharType_List.class, new com.kcdata.abe.bapi.ZshcharType(), new java.lang.String[][]{}, "HOTELS_NAME", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"HOTELS_NAME\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZSHCHAR\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZSHCHAR\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Z_Api_Resort_List_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Z_Api_Resort_List_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void setReturn(com.kcdata.abe.bapi.BapireturnType Return) {
        baseTypeData().setElementValue(0, Return);
    }

    public void setHotels_Name(com.kcdata.abe.bapi.ZshcharType[] Hotels_Name) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.ZshcharType_List());
        com.kcdata.abe.bapi.util.ZshcharType_List list$ = get_as_listHotels_Name();
        for (int  i$ = 0; i$ < Hotels_Name.length; i$++){
         list$.addZshcharType(Hotels_Name[ i$]);
        }
    }

    public com.kcdata.abe.bapi.BapireturnType getReturn() {
        return (com.kcdata.abe.bapi.BapireturnType)baseTypeData().getElementValue(0);
    }

    public void setResorts(com.kcdata.abe.bapi.util.ZshcharType_List Resorts) {
        baseTypeData().setElementValue(1, Resorts);
    }

    public void setHotels_Name(com.kcdata.abe.bapi.util.ZshcharType_List Hotels_Name) {
        baseTypeData().setElementValue(2, Hotels_Name);
    }

    public void setResorts(com.kcdata.abe.bapi.ZshcharType[] Resorts) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.ZshcharType_List());
        com.kcdata.abe.bapi.util.ZshcharType_List list$ = get_as_listResorts();
        for (int  i$ = 0; i$ < Resorts.length; i$++){
         list$.addZshcharType(Resorts[ i$]);
        }
    }

    public com.kcdata.abe.bapi.ZshcharType[] getResorts() {
        com.kcdata.abe.bapi.util.ZshcharType_List i$ = (com.kcdata.abe.bapi.util.ZshcharType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayZshcharType();
    }

    public MetaData metadataZ_Api_Resort_List_Output() {
        return metadata;
    }

    public com.kcdata.abe.bapi.ZshcharType[] getHotels_Name() {
        com.kcdata.abe.bapi.util.ZshcharType_List i$ = (com.kcdata.abe.bapi.util.ZshcharType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayZshcharType();
    }

    public com.kcdata.abe.bapi.util.ZshcharType_List get_as_listHotels_Name() {
        return (com.kcdata.abe.bapi.util.ZshcharType_List)baseTypeData().getElementValue(2);
    }

    public com.kcdata.abe.bapi.util.ZshcharType_List get_as_listResorts() {
        return (com.kcdata.abe.bapi.util.ZshcharType_List)baseTypeData().getElementValue(1);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Resort_List_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Resort_List_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getReturn() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getResorts() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getHotels_Name() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
    }

}
