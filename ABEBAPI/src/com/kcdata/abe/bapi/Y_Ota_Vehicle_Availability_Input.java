package com.kcdata.abe.bapi;
public class Y_Ota_Vehicle_Availability_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1296044373546L) ;

    private  Y_Ota_Vehicle_Availability_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_OTA_VEHICLE_AVAILABILITY.Input", 8, 0, com.kcdata.abe.bapi.Y_Ota_Vehicle_Availability_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_OTA_VEHICLE_AVAILABILITY", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Vehicle Availability</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "CH_ST_BAPI_METADATA", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_METADATA", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ch_St_Bapi_Metadata", com.kcdata.abe.bapi.Yst_MetadataType.class, new com.kcdata.abe.bapi.Yst_MetadataType(), new java.lang.String[][]{}, "CH_ST_BAPI_METADATA", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER | com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CH_ST_BAPI_METADATA\"><ifr:descriptor><ifr:description language=\"EN\">Matadata for BAPI Request Interface</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_METADATA\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_METADATA\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>changing</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IM_APPLICATION_INFO", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_APPLI_INFO", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Application_Info", com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType.class, new com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType(), new java.lang.String[][]{}, "IM_APPLICATION_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_APPLICATION_INFO\"><ifr:descriptor><ifr:description language=\"EN\">BAPI Application Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_APPLI_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_APPLI_INFO\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IM_REQ_HDR", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_REQ_HDR", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Req_Hdr", com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType.class, new com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType(), new java.lang.String[][]{}, "IM_REQ_HDR", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_REQ_HDR\"><ifr:descriptor><ifr:description language=\"EN\">Hotel Request Header</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_REQ_HDR\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_REQ_HDR\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IT_VEH_TYPE", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Veh_Type", com.kcdata.abe.bapi.util.Yst_Bapi_Veh_TypesType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType(), new java.lang.String[][]{}, "IT_VEH_TYPE", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_VEH_TYPE\"><ifr:descriptor><ifr:description language=\"EN\">Market Strategy for Rental car</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_VEH_TYPES\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_VEH_TYPES\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IT_VEH_REQ", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Veh_Req", com.kcdata.abe.bapi.util.Yst_Ota_Veh_ReqType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType(), new java.lang.String[][]{}, "IT_VEH_REQ", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_VEH_REQ\"><ifr:descriptor><ifr:description language=\"EN\">OTA Vehicle REquest</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_VEH_REQ\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_VEH_REQ\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "IT_VEH_INFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Veh_Info", com.kcdata.abe.bapi.util.Yst_Bapi_Veh_InfoType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Veh_InfoType(), new java.lang.String[][]{}, "IT_VEH_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_VEH_INFO\"><ifr:descriptor><ifr:description language=\"EN\">Rental Car Information</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_VEH_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_VEH_INFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 6, "IT_VEH_AVAILABILITY", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Veh_Availability", com.kcdata.abe.bapi.util.Yst_Ota_Veh_AvailabilityType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Veh_AvailabilityType(), new java.lang.String[][]{}, "IT_VEH_AVAILABILITY", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_VEH_AVAILABILITY\"><ifr:descriptor><ifr:description language=\"EN\">OTA Vehicle Availability</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_VEH_AVAILABILITY\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_VEH_AVAILABILITY\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 7, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Y_Ota_Vehicle_Availability_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Y_Ota_Vehicle_Availability_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(7);
    }

    public void setIt_Veh_Info(com.kcdata.abe.bapi.Yst_Bapi_Veh_InfoType[] It_Veh_Info) {
        baseTypeData().setElementValue(5, new com.kcdata.abe.bapi.util.Yst_Bapi_Veh_InfoType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Veh_InfoType_List list$ = get_as_listIt_Veh_Info();
        for (int  i$ = 0; i$ < It_Veh_Info.length; i$++){
         list$.addYst_Bapi_Veh_InfoType(It_Veh_Info[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(7);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public void setIt_Veh_Req(com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType[] It_Veh_Req) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Yst_Ota_Veh_ReqType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Veh_ReqType_List list$ = get_as_listIt_Veh_Req();
        for (int  i$ = 0; i$ < It_Veh_Req.length; i$++){
         list$.addYst_Ota_Veh_ReqType(It_Veh_Req[ i$]);
        }
    }

    public void setIm_Application_Info(com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType Im_Application_Info) {
        baseTypeData().setElementValue(1, Im_Application_Info);
    }

    public void setIt_Veh_Req(com.kcdata.abe.bapi.util.Yst_Ota_Veh_ReqType_List It_Veh_Req) {
        baseTypeData().setElementValue(4, It_Veh_Req);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType getIm_Req_Hdr() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType)baseTypeData().getElementValue(2);
    }

    public void setCh_St_Bapi_Metadata(com.kcdata.abe.bapi.Yst_MetadataType Ch_St_Bapi_Metadata) {
        baseTypeData().setElementValue(0, Ch_St_Bapi_Metadata);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Veh_AvailabilityType[] getIt_Veh_Availability() {
        com.kcdata.abe.bapi.util.Yst_Ota_Veh_AvailabilityType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Veh_AvailabilityType_List)baseTypeData().getElementValue(6);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Veh_AvailabilityType();
    }

    public void setIt_Veh_Type(com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType[] It_Veh_Type) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Yst_Bapi_Veh_TypesType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Veh_TypesType_List list$ = get_as_listIt_Veh_Type();
        for (int  i$ = 0; i$ < It_Veh_Type.length; i$++){
         list$.addYst_Bapi_Veh_TypesType(It_Veh_Type[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Veh_TypesType_List get_as_listIt_Veh_Type() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Veh_TypesType_List)baseTypeData().getElementValue(3);
    }

    public MetaData metadataY_Ota_Vehicle_Availability_Input() {
        return metadata;
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(7, It_Return);
    }

    public void setIt_Veh_Availability(com.kcdata.abe.bapi.util.Yst_Ota_Veh_AvailabilityType_List It_Veh_Availability) {
        baseTypeData().setElementValue(6, It_Veh_Availability);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Veh_ReqType[] getIt_Veh_Req() {
        com.kcdata.abe.bapi.util.Yst_Ota_Veh_ReqType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Veh_ReqType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Veh_ReqType();
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(7, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public void setIm_Req_Hdr(com.kcdata.abe.bapi.Yst_Bapi_Req_HdrType Im_Req_Hdr) {
        baseTypeData().setElementValue(2, Im_Req_Hdr);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType getIm_Application_Info() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType)baseTypeData().getElementValue(1);
    }

    public void setIt_Veh_Info(com.kcdata.abe.bapi.util.Yst_Bapi_Veh_InfoType_List It_Veh_Info) {
        baseTypeData().setElementValue(5, It_Veh_Info);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Veh_AvailabilityType_List get_as_listIt_Veh_Availability() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Veh_AvailabilityType_List)baseTypeData().getElementValue(6);
    }

    public void setIt_Veh_Availability(com.kcdata.abe.bapi.Yst_Ota_Veh_AvailabilityType[] It_Veh_Availability) {
        baseTypeData().setElementValue(6, new com.kcdata.abe.bapi.util.Yst_Ota_Veh_AvailabilityType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Veh_AvailabilityType_List list$ = get_as_listIt_Veh_Availability();
        for (int  i$ = 0; i$ < It_Veh_Availability.length; i$++){
         list$.addYst_Ota_Veh_AvailabilityType(It_Veh_Availability[ i$]);
        }
    }

    public void setIt_Veh_Type(com.kcdata.abe.bapi.util.Yst_Bapi_Veh_TypesType_List It_Veh_Type) {
        baseTypeData().setElementValue(3, It_Veh_Type);
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Veh_InfoType_List get_as_listIt_Veh_Info() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Veh_InfoType_List)baseTypeData().getElementValue(5);
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Veh_ReqType_List get_as_listIt_Veh_Req() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Veh_ReqType_List)baseTypeData().getElementValue(4);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Veh_TypesType[] getIt_Veh_Type() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Veh_TypesType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Veh_TypesType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Veh_TypesType();
    }

    public com.kcdata.abe.bapi.Yst_MetadataType getCh_St_Bapi_Metadata() {
        return (com.kcdata.abe.bapi.Yst_MetadataType)baseTypeData().getElementValue(0);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Veh_InfoType[] getIt_Veh_Info() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Veh_InfoType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Veh_InfoType_List)baseTypeData().getElementValue(5);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Veh_InfoType();
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Ota_Vehicle_Availability_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Ota_Vehicle_Availability_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Veh_Availability() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Application_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Veh_Type() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Veh_Req() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Req_Hdr() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Veh_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCh_St_Bapi_Metadata() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
