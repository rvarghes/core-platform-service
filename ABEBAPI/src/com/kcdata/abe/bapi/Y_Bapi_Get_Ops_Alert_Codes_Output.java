package com.kcdata.abe.bapi;
public class Y_Bapi_Get_Ops_Alert_Codes_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1254952123765L) ;

    private  Y_Bapi_Get_Ops_Alert_Codes_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_GET_OPS_ALERT_CODES.Output", 3, 0, com.kcdata.abe.bapi.Y_Bapi_Get_Ops_Alert_Codes_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_GET_OPS_ALERT_CODES", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">OPS alert request</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "EX_ST_RETURN", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:BAPIRET2", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ex_St_Return", com.kcdata.abe.bapi.Bapiret2Type.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "EX_ST_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"EX_ST_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IT_ALERT_TYPES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Alert_Types", com.kcdata.abe.bapi.util.Zalert_TypType_List.class, new com.kcdata.abe.bapi.Zalert_TypType(), new java.lang.String[][]{}, "IT_ALERT_TYPES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_ALERT_TYPES\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZALERT_TYP\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZALERT_TYP\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IT_ACTION_TYPES", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Action_Types", com.kcdata.abe.bapi.util.Zact_TypType_List.class, new com.kcdata.abe.bapi.Zact_TypType(), new java.lang.String[][]{}, "IT_ACTION_TYPES", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_ACTION_TYPES\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZACT_TYP\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZACT_TYP\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Y_Bapi_Get_Ops_Alert_Codes_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Y_Bapi_Get_Ops_Alert_Codes_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public com.kcdata.abe.bapi.util.Zact_TypType_List get_as_listIt_Action_Types() {
        return (com.kcdata.abe.bapi.util.Zact_TypType_List)baseTypeData().getElementValue(2);
    }

    public com.kcdata.abe.bapi.Zalert_TypType[] getIt_Alert_Types() {
        com.kcdata.abe.bapi.util.Zalert_TypType_List i$ = (com.kcdata.abe.bapi.util.Zalert_TypType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayZalert_TypType();
    }

    public void setIt_Action_Types(com.kcdata.abe.bapi.Zact_TypType[] It_Action_Types) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Zact_TypType_List());
        com.kcdata.abe.bapi.util.Zact_TypType_List list$ = get_as_listIt_Action_Types();
        for (int  i$ = 0; i$ < It_Action_Types.length; i$++){
         list$.addZact_TypType(It_Action_Types[ i$]);
        }
    }

    public void setIt_Alert_Types(com.kcdata.abe.bapi.util.Zalert_TypType_List It_Alert_Types) {
        baseTypeData().setElementValue(1, It_Alert_Types);
    }

    public com.kcdata.abe.bapi.Zact_TypType[] getIt_Action_Types() {
        com.kcdata.abe.bapi.util.Zact_TypType_List i$ = (com.kcdata.abe.bapi.util.Zact_TypType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayZact_TypType();
    }

    public void setIt_Alert_Types(com.kcdata.abe.bapi.Zalert_TypType[] It_Alert_Types) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Zalert_TypType_List());
        com.kcdata.abe.bapi.util.Zalert_TypType_List list$ = get_as_listIt_Alert_Types();
        for (int  i$ = 0; i$ < It_Alert_Types.length; i$++){
         list$.addZalert_TypType(It_Alert_Types[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Zalert_TypType_List get_as_listIt_Alert_Types() {
        return (com.kcdata.abe.bapi.util.Zalert_TypType_List)baseTypeData().getElementValue(1);
    }

    public void setIt_Action_Types(com.kcdata.abe.bapi.util.Zact_TypType_List It_Action_Types) {
        baseTypeData().setElementValue(2, It_Action_Types);
    }

    public void setEx_St_Return(com.kcdata.abe.bapi.Bapiret2Type Ex_St_Return) {
        baseTypeData().setElementValue(0, Ex_St_Return);
    }

    public MetaData metadataY_Bapi_Get_Ops_Alert_Codes_Output() {
        return metadata;
    }

    public com.kcdata.abe.bapi.Bapiret2Type getEx_St_Return() {
        return (com.kcdata.abe.bapi.Bapiret2Type)baseTypeData().getElementValue(0);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Bapi_Get_Ops_Alert_Codes_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Get_Ops_Alert_Codes_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Alert_Types() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Action_Types() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getEx_St_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
