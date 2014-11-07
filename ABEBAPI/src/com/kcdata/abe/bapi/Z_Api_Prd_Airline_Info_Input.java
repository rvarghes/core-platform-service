package com.kcdata.abe.bapi;
public class Z_Api_Prd_Airline_Info_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1247175272250L) ;

    private  Z_Api_Prd_Airline_Info_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_PRD_AIRLINE_INFO.Input", 2, 0, com.kcdata.abe.bapi.Z_Api_Prd_Airline_Info_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_PRD_AIRLINE_INFO", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Airline Information ver 1</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "AIRLINECODE", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Airlinecode", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "2"}}, "AIRLINECODE", 0, 0, -1, 2, 4, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"AIRLINECODE\"><ifr:descriptor><ifr:description language=\"EN\">Airline Code</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"ZWAIRLIMAS.ZZALCODE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:offset1>3</ifr:offset1><ifr:offset2>6</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"ZALCODE\"><ifr:properties><ifr:helpValuesSupported>false</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>2</ifr:length><ifr:internalLength1>2</ifr:internalLength1><ifr:internalLength2>4</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>2</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "MARKETINGSTRATEGY", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Marketingstrategy", com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List.class, new com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType(), new java.lang.String[][]{}, "MARKETINGSTRATEGY", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"MARKETINGSTRATEGY\"><ifr:descriptor><ifr:description language=\"EN\">Marketing Strategy Comments</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_PRD_MARKETING_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_PRD_MARKETING_INFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Z_Api_Prd_Airline_Info_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Z_Api_Prd_Airline_Info_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List get_as_listMarketingstrategy() {
        return (com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List)baseTypeData().getElementValue(1);
    }

    public void setMarketingstrategy(com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType[] Marketingstrategy) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List());
        com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List list$ = get_as_listMarketingstrategy();
        for (int  i$ = 0; i$ < Marketingstrategy.length; i$++){
         list$.addZapi_Prd_Marketing_InfoType(Marketingstrategy[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Zapi_Prd_Marketing_InfoType[] getMarketingstrategy() {
        com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Prd_Marketing_InfoType();
    }

    public void setAirlinecode(java.lang.String Airlinecode) {
        baseTypeData().setElementValue(0, Airlinecode);
    }

    public MetaData metadataZ_Api_Prd_Airline_Info_Input() {
        return metadata;
    }

    public java.lang.String getAirlinecode() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public void setMarketingstrategy(com.kcdata.abe.bapi.util.Zapi_Prd_Marketing_InfoType_List Marketingstrategy) {
        baseTypeData().setElementValue(1, Marketingstrategy);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Prd_Airline_Info_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Prd_Airline_Info_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getMarketingstrategy() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getAirlinecode() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
