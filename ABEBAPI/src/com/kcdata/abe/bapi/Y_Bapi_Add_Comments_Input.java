package com.kcdata.abe.bapi;
public class Y_Bapi_Add_Comments_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1256262725015L) ;

    private  Y_Bapi_Add_Comments_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_ADD_COMMENTS.Input", 3, 0, com.kcdata.abe.bapi.Y_Bapi_Add_Comments_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_ADD_COMMENTS", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Add Comments</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "IM_BOOKING_NUMBER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Booking_Number", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "IM_BOOKING_NUMBER", 0, 0, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_BOOKING_NUMBER\"><ifr:descriptor><ifr:description language=\"EN\">Sales Document</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"VBAK.VBELN\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:checkTable>VBUK</ifr:checkTable><ifr:offset1>3</ifr:offset1><ifr:offset2>6</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"VBELN_VA\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength><ifr:conversionExit>ALPHA</ifr:conversionExit></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IT_REPORT_LOG", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Report_Log", com.kcdata.abe.bapi.util.Yst_Bapi_Report_LogType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Report_LogType(), new java.lang.String[][]{}, "IT_REPORT_LOG", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_REPORT_LOG\"><ifr:descriptor><ifr:description language=\"EN\">Report Log data</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_REPORT_LOG\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_REPORT_LOG\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IT_COMMENTS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Comments", com.kcdata.abe.bapi.util.Yst_Bapi_CommentsType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_CommentsType(), new java.lang.String[][]{}, "IT_COMMENTS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_COMMENTS\"><ifr:descriptor><ifr:description language=\"EN\">Comments Parameter Structure.</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_COMMENTS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_COMMENTS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Y_Bapi_Add_Comments_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Y_Bapi_Add_Comments_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Report_LogType_List get_as_listIt_Report_Log() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Report_LogType_List)baseTypeData().getElementValue(1);
    }

    public java.lang.String getIm_Booking_Number() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Report_LogType[] getIt_Report_Log() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Report_LogType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Report_LogType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Report_LogType();
    }

    public MetaData metadataY_Bapi_Add_Comments_Input() {
        return metadata;
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

    public void setIm_Booking_Number(java.lang.String Im_Booking_Number) {
        baseTypeData().setElementValue(0, Im_Booking_Number);
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
    
        private  Y_Bapi_Add_Comments_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Add_Comments_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Booking_Number() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Report_Log() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Comments() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
    }

}
