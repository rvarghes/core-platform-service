package com.kcdata.abe.bapi;
public class Y_Bapi_Htl_Farerules_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1304098307968L) ;

    private  Y_Bapi_Htl_Farerules_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_HTL_FARERULES.Input", 6, 0, com.kcdata.abe.bapi.Y_Bapi_Htl_Farerules_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_HTL_FARERULES", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Hotel Rate Rules</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "CH_ST_BAPI_METADATA", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_METADATA", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ch_St_Bapi_Metadata", com.kcdata.abe.bapi.Yst_MetadataType.class, new com.kcdata.abe.bapi.Yst_MetadataType(), new java.lang.String[][]{}, "CH_ST_BAPI_METADATA", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER | com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CH_ST_BAPI_METADATA\"><ifr:descriptor><ifr:description language=\"EN\">Matadata for BAPI Request Interface</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_METADATA\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_METADATA\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>changing</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IM_APPLICATION_INFO", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_APPLI_INFO", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Application_Info", com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType.class, new com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType(), new java.lang.String[][]{}, "IM_APPLICATION_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_APPLICATION_INFO\"><ifr:descriptor><ifr:description language=\"EN\">BAPI Application Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_APPLI_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_APPLI_INFO\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IM_HTL_RTRULE_REQ", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_WS_HOTEL_DIR_RAT_RULE_REQ", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Htl_Rtrule_Req", com.kcdata.abe.bapi.Yst_Ws_Hotel_Dir_Rat_Rule_ReqType.class, new com.kcdata.abe.bapi.Yst_Ws_Hotel_Dir_Rat_Rule_ReqType(), new java.lang.String[][]{}, "IM_HTL_RTRULE_REQ", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_HTL_RTRULE_REQ\"><ifr:descriptor><ifr:description language=\"EN\">Hotel Direct Rate Rule Request</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_WS_HOTEL_DIR_RAT_RULE_REQ\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_WS_HOTEL_DIR_RAT_RULE_REQ\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IT_HTL_RM_CODE_CAT", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Htl_Rm_Code_Cat", com.kcdata.abe.bapi.util.Yst_Htl_Room_Code_CatType_List.class, new com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType(), new java.lang.String[][]{}, "IT_HTL_RM_CODE_CAT", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_HTL_RM_CODE_CAT\"><ifr:descriptor><ifr:description language=\"EN\">Hotel room code &amp; category</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_HTL_ROOM_CODE_CAT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_HTL_ROOM_CODE_CAT\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "IT_FARERULES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Farerules", com.kcdata.abe.bapi.util.Yst_Htl_FarerulesType_List.class, new com.kcdata.abe.bapi.Yst_Htl_FarerulesType(), new java.lang.String[][]{}, "IT_FARERULES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_FARERULES\"><ifr:descriptor><ifr:description language=\"EN\">SAPscript: Text Lines</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_HTL_FARERULES\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_HTL_FARERULES\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Y_Bapi_Htl_Farerules_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Y_Bapi_Htl_Farerules_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(3);
    }

    public void setIm_Htl_Rtrule_Req(com.kcdata.abe.bapi.Yst_Ws_Hotel_Dir_Rat_Rule_ReqType Im_Htl_Rtrule_Req) {
        baseTypeData().setElementValue(2, Im_Htl_Rtrule_Req);
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType getIm_Application_Info() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType)baseTypeData().getElementValue(1);
    }

    public void setIm_Application_Info(com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType Im_Application_Info) {
        baseTypeData().setElementValue(1, Im_Application_Info);
    }

    public com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType[] getIt_Htl_Rm_Code_Cat() {
        com.kcdata.abe.bapi.util.Yst_Htl_Room_Code_CatType_List i$ = (com.kcdata.abe.bapi.util.Yst_Htl_Room_Code_CatType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Htl_Room_Code_CatType();
    }

    public void setIt_Htl_Rm_Code_Cat(com.kcdata.abe.bapi.util.Yst_Htl_Room_Code_CatType_List It_Htl_Rm_Code_Cat) {
        baseTypeData().setElementValue(4, It_Htl_Rm_Code_Cat);
    }

    public void setIt_Htl_Rm_Code_Cat(com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType[] It_Htl_Rm_Code_Cat) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Yst_Htl_Room_Code_CatType_List());
        com.kcdata.abe.bapi.util.Yst_Htl_Room_Code_CatType_List list$ = get_as_listIt_Htl_Rm_Code_Cat();
        for (int  i$ = 0; i$ < It_Htl_Rm_Code_Cat.length; i$++){
         list$.addYst_Htl_Room_Code_CatType(It_Htl_Rm_Code_Cat[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Htl_FarerulesType[] getIt_Farerules() {
        com.kcdata.abe.bapi.util.Yst_Htl_FarerulesType_List i$ = (com.kcdata.abe.bapi.util.Yst_Htl_FarerulesType_List)baseTypeData().getElementValue(5);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Htl_FarerulesType();
    }

    public void setIt_Farerules(com.kcdata.abe.bapi.util.Yst_Htl_FarerulesType_List It_Farerules) {
        baseTypeData().setElementValue(5, It_Farerules);
    }

    public com.kcdata.abe.bapi.Yst_Ws_Hotel_Dir_Rat_Rule_ReqType getIm_Htl_Rtrule_Req() {
        return (com.kcdata.abe.bapi.Yst_Ws_Hotel_Dir_Rat_Rule_ReqType)baseTypeData().getElementValue(2);
    }

    public void setCh_St_Bapi_Metadata(com.kcdata.abe.bapi.Yst_MetadataType Ch_St_Bapi_Metadata) {
        baseTypeData().setElementValue(0, Ch_St_Bapi_Metadata);
    }

    public void setIt_Farerules(com.kcdata.abe.bapi.Yst_Htl_FarerulesType[] It_Farerules) {
        baseTypeData().setElementValue(5, new com.kcdata.abe.bapi.util.Yst_Htl_FarerulesType_List());
        com.kcdata.abe.bapi.util.Yst_Htl_FarerulesType_List list$ = get_as_listIt_Farerules();
        for (int  i$ = 0; i$ < It_Farerules.length; i$++){
         list$.addYst_Htl_FarerulesType(It_Farerules[ i$]);
        }
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(3, It_Return);
    }

    public MetaData metadataY_Bapi_Htl_Farerules_Input() {
        return metadata;
    }

    public com.kcdata.abe.bapi.util.Yst_Htl_FarerulesType_List get_as_listIt_Farerules() {
        return (com.kcdata.abe.bapi.util.Yst_Htl_FarerulesType_List)baseTypeData().getElementValue(5);
    }

    public com.kcdata.abe.bapi.util.Yst_Htl_Room_Code_CatType_List get_as_listIt_Htl_Rm_Code_Cat() {
        return (com.kcdata.abe.bapi.util.Yst_Htl_Room_Code_CatType_List)baseTypeData().getElementValue(4);
    }

    public com.kcdata.abe.bapi.Yst_MetadataType getCh_St_Bapi_Metadata() {
        return (com.kcdata.abe.bapi.Yst_MetadataType)baseTypeData().getElementValue(0);
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Bapi_Htl_Farerules_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Htl_Farerules_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Htl_Rm_Code_Cat() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Application_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Farerules() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Htl_Rtrule_Req() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCh_St_Bapi_Metadata() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
