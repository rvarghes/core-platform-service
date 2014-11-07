package com.kcdata.abe.bapi;
public class Y_Bapi_Sked_Adv_Search_Details_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1250104867296L) ;

    private  Y_Bapi_Sked_Adv_Search_Details_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_SKED_ADV_SEARCH_DETAILS.Input", 6, 0, com.kcdata.abe.bapi.Y_Bapi_Sked_Adv_Search_Details_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_SKED_ADV_SEARCH_DETAILS", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">BAPI for Advanced Sked search</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "CH_ST_BAPI_METADATA", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_METADATA", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Ch_St_Bapi_Metadata", com.kcdata.abe.bapi.Yst_MetadataType.class, new com.kcdata.abe.bapi.Yst_MetadataType(), new java.lang.String[][]{}, "CH_ST_BAPI_METADATA", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER | com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CH_ST_BAPI_METADATA\"><ifr:descriptor><ifr:description language=\"EN\">Matadata for BAPI Request Interface</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_METADATA\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_METADATA\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>changing</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IM_APPLICATION_INFO", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_APPLI_INFO", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Application_Info", com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType.class, new com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType(), new java.lang.String[][]{}, "IM_APPLICATION_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_APPLICATION_INFO\"><ifr:descriptor><ifr:description language=\"EN\">Application Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_APPLI_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_APPLI_INFO\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IT_SELECT_PARA", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Select_Para", com.kcdata.abe.bapi.util.Yst_Air_SelectionType_List.class, new com.kcdata.abe.bapi.Yst_Air_SelectionType(), new java.lang.String[][]{}, "IT_SELECT_PARA", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_SELECT_PARA\"><ifr:descriptor><ifr:description language=\"EN\">Quotation - Air Selection.</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_AIR_SELECTION\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_AIR_SELECTION\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IT_BAPI_STOPOVER_INFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Bapi_Stopover_Info", com.kcdata.abe.bapi.util.Yst_Bapi_Stopover_InfoType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType(), new java.lang.String[][]{}, "IT_BAPI_STOPOVER_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_BAPI_STOPOVER_INFO\"><ifr:descriptor><ifr:description language=\"EN\">List of Stopover Cities for BAPI</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_STOPOVER_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_STOPOVER_INFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "IT_BAPI_CARRINFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Bapi_Carrinfo", com.kcdata.abe.bapi.util.Yst_Bapi_Carri_InfoType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType(), new java.lang.String[][]{}, "IT_BAPI_CARRINFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_BAPI_CARRINFO\"><ifr:descriptor><ifr:description language=\"EN\">Refined Flight Search for BAPI</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_CARRI_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_CARRI_INFO\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Y_Bapi_Sked_Adv_Search_Details_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Y_Bapi_Sked_Adv_Search_Details_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setIt_Bapi_Stopover_Info(com.kcdata.abe.bapi.util.Yst_Bapi_Stopover_InfoType_List It_Bapi_Stopover_Info) {
        baseTypeData().setElementValue(4, It_Bapi_Stopover_Info);
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(3);
    }

    public MetaData metadataY_Bapi_Sked_Adv_Search_Details_Input() {
        return metadata;
    }

    public void setIt_Bapi_Carrinfo(com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType[] It_Bapi_Carrinfo) {
        baseTypeData().setElementValue(5, new com.kcdata.abe.bapi.util.Yst_Bapi_Carri_InfoType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Carri_InfoType_List list$ = get_as_listIt_Bapi_Carrinfo();
        for (int  i$ = 0; i$ < It_Bapi_Carrinfo.length; i$++){
         list$.addYst_Bapi_Carri_InfoType(It_Bapi_Carrinfo[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Carri_InfoType[] getIt_Bapi_Carrinfo() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Carri_InfoType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Carri_InfoType_List)baseTypeData().getElementValue(5);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Carri_InfoType();
    }

    public void setIt_Bapi_Carrinfo(com.kcdata.abe.bapi.util.Yst_Bapi_Carri_InfoType_List It_Bapi_Carrinfo) {
        baseTypeData().setElementValue(5, It_Bapi_Carrinfo);
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Carri_InfoType_List get_as_listIt_Bapi_Carrinfo() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Carri_InfoType_List)baseTypeData().getElementValue(5);
    }

    public void setIt_Select_Para(com.kcdata.abe.bapi.util.Yst_Air_SelectionType_List It_Select_Para) {
        baseTypeData().setElementValue(2, It_Select_Para);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType getIm_Application_Info() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType)baseTypeData().getElementValue(1);
    }

    public void setIm_Application_Info(com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType Im_Application_Info) {
        baseTypeData().setElementValue(1, Im_Application_Info);
    }

    public com.kcdata.abe.bapi.Yst_Air_SelectionType[] getIt_Select_Para() {
        com.kcdata.abe.bapi.util.Yst_Air_SelectionType_List i$ = (com.kcdata.abe.bapi.util.Yst_Air_SelectionType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Air_SelectionType();
    }

    public void setIt_Select_Para(com.kcdata.abe.bapi.Yst_Air_SelectionType[] It_Select_Para) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Yst_Air_SelectionType_List());
        com.kcdata.abe.bapi.util.Yst_Air_SelectionType_List list$ = get_as_listIt_Select_Para();
        for (int  i$ = 0; i$ < It_Select_Para.length; i$++){
         list$.addYst_Air_SelectionType(It_Select_Para[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType[] getIt_Bapi_Stopover_Info() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Stopover_InfoType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Stopover_InfoType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Stopover_InfoType();
    }

    public void setCh_St_Bapi_Metadata(com.kcdata.abe.bapi.Yst_MetadataType Ch_St_Bapi_Metadata) {
        baseTypeData().setElementValue(0, Ch_St_Bapi_Metadata);
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Stopover_InfoType_List get_as_listIt_Bapi_Stopover_Info() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Stopover_InfoType_List)baseTypeData().getElementValue(4);
    }

    public com.kcdata.abe.bapi.util.Yst_Air_SelectionType_List get_as_listIt_Select_Para() {
        return (com.kcdata.abe.bapi.util.Yst_Air_SelectionType_List)baseTypeData().getElementValue(2);
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(3, It_Return);
    }

    public void setIt_Bapi_Stopover_Info(com.kcdata.abe.bapi.Yst_Bapi_Stopover_InfoType[] It_Bapi_Stopover_Info) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Yst_Bapi_Stopover_InfoType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Stopover_InfoType_List list$ = get_as_listIt_Bapi_Stopover_Info();
        for (int  i$ = 0; i$ < It_Bapi_Stopover_Info.length; i$++){
         list$.addYst_Bapi_Stopover_InfoType(It_Bapi_Stopover_Info[ i$]);
        }
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
    
        private  Y_Bapi_Sked_Adv_Search_Details_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Sked_Adv_Search_Details_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Bapi_Carrinfo() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Application_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Select_Para() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Bapi_Stopover_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCh_St_Bapi_Metadata() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
