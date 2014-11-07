package com.kcdata.abe.bapi;
public class Y_Bapi_Get_Alerts_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1286553933234L) ;

    private  Y_Bapi_Get_Alerts_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_GET_ALERTS.Output", 5, 0, com.kcdata.abe.bapi.Y_Bapi_Get_Alerts_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_GET_ALERTS", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Get Alerts</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "CH_ST_BAPI_METADATA", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_METADATA", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ch_St_Bapi_Metadata", com.kcdata.abe.bapi.Yst_MetadataType.class, new com.kcdata.abe.bapi.Yst_MetadataType(), new java.lang.String[][]{}, "CH_ST_BAPI_METADATA", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER | com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CH_ST_BAPI_METADATA\"><ifr:descriptor><ifr:description language=\"EN\">Matadata for BAPI Request Interface</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_METADATA\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_METADATA\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>changing</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IT_INPUTINFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Inputinfo", com.kcdata.abe.bapi.util.Yst_Bapi_Prd_AlertsType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType(), new java.lang.String[][]{}, "IT_INPUTINFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_INPUTINFO\"><ifr:descriptor><ifr:description language=\"EN\">Alerts Input Values</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_PRD_ALERTS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_PRD_ALERTS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IT_ALERTS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Alerts", com.kcdata.abe.bapi.util.Zsalert2Type_List.class, new com.kcdata.abe.bapi.Zsalert2Type(), new java.lang.String[][]{}, "IT_ALERTS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_ALERTS\"><ifr:descriptor><ifr:description language=\"EN\">Alert interface</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZSALERT2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZSALERT2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IT_AGENT_ADVISORY", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Agent_Advisory", com.kcdata.abe.bapi.util.Zsalert2Type_List.class, new com.kcdata.abe.bapi.Zsalert2Type(), new java.lang.String[][]{}, "IT_AGENT_ADVISORY", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_AGENT_ADVISORY\"><ifr:descriptor><ifr:description language=\"EN\">Alert interface</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZSALERT2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZSALERT2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Y_Bapi_Get_Alerts_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Y_Bapi_Get_Alerts_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(1);
    }

    public com.kcdata.abe.bapi.util.Zsalert2Type_List get_as_listIt_Alerts() {
        return (com.kcdata.abe.bapi.util.Zsalert2Type_List)baseTypeData().getElementValue(3);
    }

    public void setIt_Alerts(com.kcdata.abe.bapi.Zsalert2Type[] It_Alerts) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Zsalert2Type_List());
        com.kcdata.abe.bapi.util.Zsalert2Type_List list$ = get_as_listIt_Alerts();
        for (int  i$ = 0; i$ < It_Alerts.length; i$++){
         list$.addZsalert2Type(It_Alerts[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Prd_AlertsType_List get_as_listIt_Inputinfo() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Prd_AlertsType_List)baseTypeData().getElementValue(2);
    }

    public com.kcdata.abe.bapi.Zsalert2Type[] getIt_Agent_Advisory() {
        com.kcdata.abe.bapi.util.Zsalert2Type_List i$ = (com.kcdata.abe.bapi.util.Zsalert2Type_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayZsalert2Type();
    }

    public void setIt_Alerts(com.kcdata.abe.bapi.util.Zsalert2Type_List It_Alerts) {
        baseTypeData().setElementValue(3, It_Alerts);
    }

    public void setIt_Inputinfo(com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType[] It_Inputinfo) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Yst_Bapi_Prd_AlertsType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Prd_AlertsType_List list$ = get_as_listIt_Inputinfo();
        for (int  i$ = 0; i$ < It_Inputinfo.length; i$++){
         list$.addYst_Bapi_Prd_AlertsType(It_Inputinfo[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Prd_AlertsType[] getIt_Inputinfo() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Prd_AlertsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Prd_AlertsType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Prd_AlertsType();
    }

    public void setCh_St_Bapi_Metadata(com.kcdata.abe.bapi.Yst_MetadataType Ch_St_Bapi_Metadata) {
        baseTypeData().setElementValue(0, Ch_St_Bapi_Metadata);
    }

    public void setIt_Inputinfo(com.kcdata.abe.bapi.util.Yst_Bapi_Prd_AlertsType_List It_Inputinfo) {
        baseTypeData().setElementValue(2, It_Inputinfo);
    }

    public void setIt_Agent_Advisory(com.kcdata.abe.bapi.Zsalert2Type[] It_Agent_Advisory) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Zsalert2Type_List());
        com.kcdata.abe.bapi.util.Zsalert2Type_List list$ = get_as_listIt_Agent_Advisory();
        for (int  i$ = 0; i$ < It_Agent_Advisory.length; i$++){
         list$.addZsalert2Type(It_Agent_Advisory[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Zsalert2Type_List get_as_listIt_Agent_Advisory() {
        return (com.kcdata.abe.bapi.util.Zsalert2Type_List)baseTypeData().getElementValue(4);
    }

    public com.kcdata.abe.bapi.Zsalert2Type[] getIt_Alerts() {
        com.kcdata.abe.bapi.util.Zsalert2Type_List i$ = (com.kcdata.abe.bapi.util.Zsalert2Type_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayZsalert2Type();
    }

    public MetaData metadataY_Bapi_Get_Alerts_Output() {
        return metadata;
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(1, It_Return);
    }

    public void setIt_Agent_Advisory(com.kcdata.abe.bapi.util.Zsalert2Type_List It_Agent_Advisory) {
        baseTypeData().setElementValue(4, It_Agent_Advisory);
    }

    public com.kcdata.abe.bapi.Yst_MetadataType getCh_St_Bapi_Metadata() {
        return (com.kcdata.abe.bapi.Yst_MetadataType)baseTypeData().getElementValue(0);
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Bapi_Get_Alerts_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Get_Alerts_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Alerts() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Agent_Advisory() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Inputinfo() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCh_St_Bapi_Metadata() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
