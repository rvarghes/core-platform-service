package com.kcdata.abe.bapi;
public class Y_Ota_Flight_Info_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1294269645406L) ;

    private  Y_Ota_Flight_Info_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_OTA_FLIGHT_INFO.Output", 5, 0, com.kcdata.abe.bapi.Y_Ota_Flight_Info_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_OTA_FLIGHT_INFO", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Flight Info</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "CH_ST_BAPI_METADATA", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_METADATA", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ch_St_Bapi_Metadata", com.kcdata.abe.bapi.Yst_MetadataType.class, new com.kcdata.abe.bapi.Yst_MetadataType(), new java.lang.String[][]{}, "CH_ST_BAPI_METADATA", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER | com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CH_ST_BAPI_METADATA\"><ifr:descriptor><ifr:description language=\"EN\">Matadata for BAPI Request Interface</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_METADATA\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_METADATA\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>changing</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "EX_IN_FLIGHT_INFO", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_FLIGHTINFO", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ex_In_Flight_Info", com.kcdata.abe.bapi.Yst_Ota_FlightinfoType.class, new com.kcdata.abe.bapi.Yst_Ota_FlightinfoType(), new java.lang.String[][]{}, "EX_IN_FLIGHT_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"EX_IN_FLIGHT_INFO\"><ifr:descriptor><ifr:description language=\"EN\">OTA Flight Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLIGHTINFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLIGHTINFO\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "EX_OUT_FLIGHT_INFO", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_FLIGHTINFO", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ex_Out_Flight_Info", com.kcdata.abe.bapi.Yst_Ota_FlightinfoType.class, new com.kcdata.abe.bapi.Yst_Ota_FlightinfoType(), new java.lang.String[][]{}, "EX_OUT_FLIGHT_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"EX_OUT_FLIGHT_INFO\"><ifr:descriptor><ifr:description language=\"EN\">OTA Flight Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLIGHTINFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLIGHTINFO\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IT_FLIGHT_LEG", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Flight_Leg", com.kcdata.abe.bapi.util.Yst_Ota_Flight_LegType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Flight_LegType(), new java.lang.String[][]{}, "IT_FLIGHT_LEG", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_FLIGHT_LEG\"><ifr:descriptor><ifr:description language=\"EN\">OTA Flight Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLIGHT_LEG\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLIGHT_LEG\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Y_Ota_Flight_Info_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Y_Ota_Flight_Info_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(3);
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public MetaData metadataY_Ota_Flight_Info_Output() {
        return metadata;
    }

    public void setIt_Flight_Leg(com.kcdata.abe.bapi.util.Yst_Ota_Flight_LegType_List It_Flight_Leg) {
        baseTypeData().setElementValue(4, It_Flight_Leg);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Flight_LegType_List get_as_listIt_Flight_Leg() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Flight_LegType_List)baseTypeData().getElementValue(4);
    }

    public void setCh_St_Bapi_Metadata(com.kcdata.abe.bapi.Yst_MetadataType Ch_St_Bapi_Metadata) {
        baseTypeData().setElementValue(0, Ch_St_Bapi_Metadata);
    }

    public com.kcdata.abe.bapi.Yst_Ota_FlightinfoType getEx_Out_Flight_Info() {
        return (com.kcdata.abe.bapi.Yst_Ota_FlightinfoType)baseTypeData().getElementValue(2);
    }

    public void setEx_In_Flight_Info(com.kcdata.abe.bapi.Yst_Ota_FlightinfoType Ex_In_Flight_Info) {
        baseTypeData().setElementValue(1, Ex_In_Flight_Info);
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(3, It_Return);
    }

    public void setEx_Out_Flight_Info(com.kcdata.abe.bapi.Yst_Ota_FlightinfoType Ex_Out_Flight_Info) {
        baseTypeData().setElementValue(2, Ex_Out_Flight_Info);
    }

    public void setIt_Flight_Leg(com.kcdata.abe.bapi.Yst_Ota_Flight_LegType[] It_Flight_Leg) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Yst_Ota_Flight_LegType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Flight_LegType_List list$ = get_as_listIt_Flight_Leg();
        for (int  i$ = 0; i$ < It_Flight_Leg.length; i$++){
         list$.addYst_Ota_Flight_LegType(It_Flight_Leg[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flight_LegType[] getIt_Flight_Leg() {
        com.kcdata.abe.bapi.util.Yst_Ota_Flight_LegType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Flight_LegType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Flight_LegType();
    }

    public com.kcdata.abe.bapi.Yst_MetadataType getCh_St_Bapi_Metadata() {
        return (com.kcdata.abe.bapi.Yst_MetadataType)baseTypeData().getElementValue(0);
    }

    public com.kcdata.abe.bapi.Yst_Ota_FlightinfoType getEx_In_Flight_Info() {
        return (com.kcdata.abe.bapi.Yst_Ota_FlightinfoType)baseTypeData().getElementValue(1);
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Ota_Flight_Info_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Ota_Flight_Info_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getEx_Out_Flight_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Flight_Leg() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getEx_In_Flight_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCh_St_Bapi_Metadata() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
