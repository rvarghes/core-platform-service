package com.kcdata.abe.bapi;
public class Y_Bapi_Create_Ops_Alert_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1254952178828L) ;

    private  Y_Bapi_Create_Ops_Alert_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_CREATE_OPS_ALERT.Input", 4, 0, com.kcdata.abe.bapi.Y_Bapi_Create_Ops_Alert_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_CREATE_OPS_ALERT", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Function Module to create OPS ALERTS</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "IM_ST_ALERT_HDR", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZALERT_HD", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_St_Alert_Hdr", com.kcdata.abe.bapi.Zalert_HdType.class, new com.kcdata.abe.bapi.Zalert_HdType(), new java.lang.String[][]{}, "IM_ST_ALERT_HDR", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_ST_ALERT_HDR\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZALERT_HD\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZALERT_HD\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IM_ST_ALERT_ITM", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZALERT_IT", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_St_Alert_Itm", com.kcdata.abe.bapi.Zalert_ItType.class, new com.kcdata.abe.bapi.Zalert_ItType(), new java.lang.String[][]{}, "IM_ST_ALERT_ITM", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_ST_ALERT_ITM\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZALERT_IT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZALERT_IT\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IM_ST_GENERAL_INFO", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_OPSINFO", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_St_General_Info", com.kcdata.abe.bapi.Zapi_OpsinfoType.class, new com.kcdata.abe.bapi.Zapi_OpsinfoType(), new java.lang.String[][]{}, "IM_ST_GENERAL_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_ST_GENERAL_INFO\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZAPI_OPSINFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_OPSINFO\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IT_PAX_ASSIGN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Pax_Assign", com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List.class, new com.kcdata.abe.bapi.Zapi_ZpaxrecapType(), new java.lang.String[][]{}, "IT_PAX_ASSIGN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_PAX_ASSIGN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_ZPAXRECAP\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_ZPAXRECAP\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Y_Bapi_Create_Ops_Alert_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Y_Bapi_Create_Ops_Alert_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setIt_Pax_Assign(com.kcdata.abe.bapi.Zapi_ZpaxrecapType[] It_Pax_Assign) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List());
        com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List list$ = get_as_listIt_Pax_Assign();
        for (int  i$ = 0; i$ < It_Pax_Assign.length; i$++){
         list$.addZapi_ZpaxrecapType(It_Pax_Assign[ i$]);
        }
    }

    public void setIm_St_Alert_Itm(com.kcdata.abe.bapi.Zalert_ItType Im_St_Alert_Itm) {
        baseTypeData().setElementValue(1, Im_St_Alert_Itm);
    }

    public com.kcdata.abe.bapi.Zalert_HdType getIm_St_Alert_Hdr() {
        return (com.kcdata.abe.bapi.Zalert_HdType)baseTypeData().getElementValue(0);
    }

    public com.kcdata.abe.bapi.Zapi_ZpaxrecapType[] getIt_Pax_Assign() {
        com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List i$ = (com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_ZpaxrecapType();
    }

    public com.kcdata.abe.bapi.Zalert_ItType getIm_St_Alert_Itm() {
        return (com.kcdata.abe.bapi.Zalert_ItType)baseTypeData().getElementValue(1);
    }

    public MetaData metadataY_Bapi_Create_Ops_Alert_Input() {
        return metadata;
    }

    public void setIt_Pax_Assign(com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List It_Pax_Assign) {
        baseTypeData().setElementValue(3, It_Pax_Assign);
    }

    public com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List get_as_listIt_Pax_Assign() {
        return (com.kcdata.abe.bapi.util.Zapi_ZpaxrecapType_List)baseTypeData().getElementValue(3);
    }

    public com.kcdata.abe.bapi.Zapi_OpsinfoType getIm_St_General_Info() {
        return (com.kcdata.abe.bapi.Zapi_OpsinfoType)baseTypeData().getElementValue(2);
    }

    public void setIm_St_General_Info(com.kcdata.abe.bapi.Zapi_OpsinfoType Im_St_General_Info) {
        baseTypeData().setElementValue(2, Im_St_General_Info);
    }

    public void setIm_St_Alert_Hdr(com.kcdata.abe.bapi.Zalert_HdType Im_St_Alert_Hdr) {
        baseTypeData().setElementValue(0, Im_St_Alert_Hdr);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Bapi_Create_Ops_Alert_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Create_Ops_Alert_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_St_Alert_Hdr() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Pax_Assign() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_St_Alert_Itm() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_St_General_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
    }

}
