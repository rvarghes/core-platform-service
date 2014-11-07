package com.kcdata.abe.bapi;
public class Y_Ota_Alt_Duration_Charter_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1406544458382L) ;

    private  Y_Ota_Alt_Duration_Charter_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_OTA_ALT_DURATION_CHARTER.Output", 3, 0, com.kcdata.abe.bapi.Y_Ota_Alt_Duration_Charter_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_OTA_ALT_DURATION_CHARTER", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\"> Alternative Duration Charter</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "EX_ALT_CHARTER_DURATION", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_OTA_ALT_DUR_CHARTER", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ex_Alt_Charter_Duration", com.kcdata.abe.bapi.Yst_Ota_Alt_Dur_CharterType.class, new com.kcdata.abe.bapi.Yst_Ota_Alt_Dur_CharterType(), new java.lang.String[][]{}, "EX_ALT_CHARTER_DURATION", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"EX_ALT_CHARTER_DURATION\"><ifr:descriptor><ifr:description language=\"EN\">OTA Structure of Alternative Duration Charter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_ALT_DUR_CHARTER\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_ALT_DUR_CHARTER\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IT_OTA_FLT_REQ", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Ota_Flt_Req", com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List.class, new com.kcdata.abe.bapi.Yst_Ota_Flt_ReqType(), new java.lang.String[][]{}, "IT_OTA_FLT_REQ", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_OTA_FLT_REQ\"><ifr:descriptor><ifr:description language=\"EN\">Flight Request</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_OTA_FLT_REQ\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_OTA_FLT_REQ\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Y_Ota_Alt_Duration_Charter_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Y_Ota_Alt_Duration_Charter_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setIt_Ota_Flt_Req(com.kcdata.abe.bapi.Yst_Ota_Flt_ReqType[] It_Ota_Flt_Req) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List());
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List list$ = get_as_listIt_Ota_Flt_Req();
        for (int  i$ = 0; i$ < It_Ota_Flt_Req.length; i$++){
         list$.addYst_Ota_Flt_ReqType(It_Ota_Flt_Req[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List get_as_listIt_Ota_Flt_Req() {
        return (com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List)baseTypeData().getElementValue(2);
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(1, It_Return);
    }

    public com.kcdata.abe.bapi.Yst_Ota_Alt_Dur_CharterType getEx_Alt_Charter_Duration() {
        return (com.kcdata.abe.bapi.Yst_Ota_Alt_Dur_CharterType)baseTypeData().getElementValue(0);
    }

    public MetaData metadataY_Ota_Alt_Duration_Charter_Output() {
        return metadata;
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(1);
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public void setEx_Alt_Charter_Duration(com.kcdata.abe.bapi.Yst_Ota_Alt_Dur_CharterType Ex_Alt_Charter_Duration) {
        baseTypeData().setElementValue(0, Ex_Alt_Charter_Duration);
    }

    public void setIt_Ota_Flt_Req(com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List It_Ota_Flt_Req) {
        baseTypeData().setElementValue(2, It_Ota_Flt_Req);
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public com.kcdata.abe.bapi.Yst_Ota_Flt_ReqType[] getIt_Ota_Flt_Req() {
        com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List i$ = (com.kcdata.abe.bapi.util.Yst_Ota_Flt_ReqType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Ota_Flt_ReqType();
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Ota_Alt_Duration_Charter_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Ota_Alt_Duration_Charter_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getEx_Alt_Charter_Duration() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Ota_Flt_Req() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
    }

}
