package com.kcdata.abe.bapi;
public class Y_Bapi_Add_Comments_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1256262725015L) ;

    private  Y_Bapi_Add_Comments_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_ADD_COMMENTS.Output", 3, 0, com.kcdata.abe.bapi.Y_Bapi_Add_Comments_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_ADD_COMMENTS", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Add Comments</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "ES_RETURN", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:BAPIRETURN", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Es_Return", com.kcdata.abe.bapi.BapireturnType.class, new com.kcdata.abe.bapi.BapireturnType(), new java.lang.String[][]{}, "ES_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"ES_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRETURN\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRETURN\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IT_REPORT_LOG", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Report_Log", com.kcdata.abe.bapi.util.Yst_Bapi_Report_LogType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Report_LogType(), new java.lang.String[][]{}, "IT_REPORT_LOG", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_REPORT_LOG\"><ifr:descriptor><ifr:description language=\"EN\">Report Log data</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_REPORT_LOG\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_REPORT_LOG\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IT_COMMENTS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Comments", com.kcdata.abe.bapi.util.Yst_Bapi_CommentsType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_CommentsType(), new java.lang.String[][]{}, "IT_COMMENTS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_COMMENTS\"><ifr:descriptor><ifr:description language=\"EN\">Comments Parameter Structure.</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_COMMENTS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_COMMENTS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Y_Bapi_Add_Comments_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Y_Bapi_Add_Comments_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Report_LogType_List get_as_listIt_Report_Log() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Report_LogType_List)baseTypeData().getElementValue(1);
    }

    public MetaData metadataY_Bapi_Add_Comments_Output() {
        return metadata;
    }

    public void setEs_Return(com.kcdata.abe.bapi.BapireturnType Es_Return) {
        baseTypeData().setElementValue(0, Es_Return);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Report_LogType[] getIt_Report_Log() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Report_LogType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Report_LogType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Report_LogType();
    }

    public void setIt_Report_Log(com.kcdata.abe.bapi.Yst_Bapi_Report_LogType[] It_Report_Log) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Yst_Bapi_Report_LogType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Report_LogType_List list$ = get_as_listIt_Report_Log();
        for (int  i$ = 0; i$ < It_Report_Log.length; i$++){
         list$.addYst_Bapi_Report_LogType(It_Report_Log[ i$]);
        }
    }

    public void setIt_Report_Log(com.kcdata.abe.bapi.util.Yst_Bapi_Report_LogType_List It_Report_Log) {
        baseTypeData().setElementValue(1, It_Report_Log);
    }

    public com.kcdata.abe.bapi.BapireturnType getEs_Return() {
        return (com.kcdata.abe.bapi.BapireturnType)baseTypeData().getElementValue(0);
    }

    public void setIt_Comments(com.kcdata.abe.bapi.Yst_Bapi_CommentsType[] It_Comments) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Yst_Bapi_CommentsType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_CommentsType_List list$ = get_as_listIt_Comments();
        for (int  i$ = 0; i$ < It_Comments.length; i$++){
         list$.addYst_Bapi_CommentsType(It_Comments[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_CommentsType_List get_as_listIt_Comments() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_CommentsType_List)baseTypeData().getElementValue(2);
    }

    public void setIt_Comments(com.kcdata.abe.bapi.util.Yst_Bapi_CommentsType_List It_Comments) {
        baseTypeData().setElementValue(2, It_Comments);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_CommentsType[] getIt_Comments() {
        com.kcdata.abe.bapi.util.Yst_Bapi_CommentsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_CommentsType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_CommentsType();
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Bapi_Add_Comments_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Add_Comments_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Report_Log() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getEs_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Comments() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
    }

}
