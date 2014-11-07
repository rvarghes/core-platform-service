package com.kcdata.abe.bapi;
public class Z_Api_Prd_Airline_Info_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1247175272250L) ;

    private  Z_Api_Prd_Airline_Info_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_PRD_AIRLINE_INFO.Output", 3, 0, com.kcdata.abe.bapi.Z_Api_Prd_Airline_Info_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_PRD_AIRLINE_INFO", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Airline Information ver 1</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "AIRLINEINFO", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_PRD_AIRLINE_INFO", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Airlineinfo", com.kcdata.abe.bapi.Zapi_Prd_Airline_InfoType.class, new com.kcdata.abe.bapi.Zapi_Prd_Airline_InfoType(), new java.lang.String[][]{}, "AIRLINEINFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"AIRLINEINFO\"><ifr:descriptor><ifr:description language=\"EN\">Airline Information</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_PRD_AIRLINE_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_PRD_AIRLINE_INFO\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "RETURN", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:BAPIRETURN", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Return", com.kcdata.abe.bapi.BapireturnType.class, new com.kcdata.abe.bapi.BapireturnType(), new java.lang.String[][]{}, "RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Message</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRETURN\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRETURN\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "MARKETINGSTRATEGY", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Marketingstrategy", com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List.class, new com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType(), new java.lang.String[][]{}, "MARKETINGSTRATEGY", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"MARKETINGSTRATEGY\"><ifr:descriptor><ifr:description language=\"EN\">Marketing Strategy Comments</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_PRD_MARKETING_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_PRD_MARKETING_INFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Z_Api_Prd_Airline_Info_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Z_Api_Prd_Airline_Info_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List get_as_listMarketingstrategy() {
        return (com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List)baseTypeData().getElementValue(2);
    }

    public void setMarketingstrategy(com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType[] Marketingstrategy) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List());
        com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List list$ = get_as_listMarketingstrategy();
        for (int  i$ = 0; i$ < Marketingstrategy.length; i$++){
         list$.addZapi_Prd_Marketing_InfoType(Marketingstrategy[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType[] getMarketingstrategy() {
        com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Prd_Marketing_InfoType();
    }

    public void setReturn(com.kcdata.abe.bapi.BapireturnType Return) {
        baseTypeData().setElementValue(1, Return);
    }

    public MetaData metadataZ_Api_Prd_Airline_Info_Output() {
        return metadata;
    }

    public com.kcdata.abe.bapi.BapireturnType getReturn() {
        return (com.kcdata.abe.bapi.BapireturnType)baseTypeData().getElementValue(1);
    }

    public void setAirlineinfo(com.kcdata.abe.bapi.Zapi_Prd_Airline_InfoType Airlineinfo) {
        baseTypeData().setElementValue(0, Airlineinfo);
    }

    public com.kcdata.abe.bapi.Zapi_Prd_Airline_InfoType getAirlineinfo() {
        return (com.kcdata.abe.bapi.Zapi_Prd_Airline_InfoType)baseTypeData().getElementValue(0);
    }

    public void setMarketingstrategy(com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List Marketingstrategy) {
        baseTypeData().setElementValue(2, Marketingstrategy);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Prd_Airline_Info_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Prd_Airline_Info_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getMarketingstrategy() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getReturn() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getAirlineinfo() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
    }

}
