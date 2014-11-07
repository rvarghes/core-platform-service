package com.kcdata.abe.bapi;
public class Y_Bapi_Apply_Payment_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1300368487812L) ;

    private  Y_Bapi_Apply_Payment_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_APPLY_PAYMENT.Input", 10, 0, com.kcdata.abe.bapi.Y_Bapi_Apply_Payment_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_APPLY_PAYMENT", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Apply Payment</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "IM_APPLICATION_INFO", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_APPLI_INFO", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Application_Info", com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType.class, new com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType(), new java.lang.String[][]{}, "IM_APPLICATION_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_APPLICATION_INFO\"><ifr:descriptor><ifr:description language=\"EN\">BAPI Application Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_APPLI_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_APPLI_INFO\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IM_BOOKINGNUMBER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Bookingnumber", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "IM_BOOKINGNUMBER", 0, 0, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_BOOKINGNUMBER\"><ifr:descriptor><ifr:description language=\"EN\">Sales Document</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"VBAK.VBELN\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:checkTable>VBUK</ifr:checkTable><ifr:offset1>3</ifr:offset1><ifr:offset2>6</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"VBELN_VA\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength><ifr:conversionExit>ALPHA</ifr:conversionExit></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IM_CCARDDETAILS", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_CREDIT_CARD", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Im_Ccarddetails", com.kcdata.abe.bapi.Zapi_Credit_CardType.class, new com.kcdata.abe.bapi.Zapi_Credit_CardType(), new java.lang.String[][]{}, "IM_CCARDDETAILS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_CCARDDETAILS\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Credit Card Payment</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_CREDIT_CARD\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_CREDIT_CARD\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IM_FLAG_CCARD", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Flag_Ccard", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "IM_FLAG_CCARD", 0, 0, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_FLAG_CCARD\"><ifr:descriptor><ifr:description language=\"EN\">Checkbox</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"ZISSPI.ZZVALIDYN\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>65</ifr:offset1><ifr:offset2>124</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"XFELD\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>true</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IM_FLAG_GCHECK", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Flag_Gcheck", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "IM_FLAG_GCHECK", 0, 0, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_FLAG_GCHECK\"><ifr:descriptor><ifr:description language=\"EN\">Checkbox</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"ZISSPI.ZZVALIDYN\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>65</ifr:offset1><ifr:offset2>124</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"XFELD\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>true</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "IM_FLAG_MTRANS", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Flag_Mtrans", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "1"}}, "IM_FLAG_MTRANS", 0, 0, -1, 1, 2, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_FLAG_MTRANS\"><ifr:descriptor><ifr:description language=\"EN\">Checkbox</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"ZISSPI.ZZVALIDYN\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:offset1>65</ifr:offset1><ifr:offset2>124</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"XFELD\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>true</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>1</ifr:length><ifr:internalLength1>1</ifr:internalLength1><ifr:internalLength2>2</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>1</ifr:outputLength></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 6, "IM_GCHECKDETAILS", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_GUARANTEE_CHECK", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Im_Gcheckdetails", com.kcdata.abe.bapi.Zapi_Guarantee_CheckType.class, new com.kcdata.abe.bapi.Zapi_Guarantee_CheckType(), new java.lang.String[][]{}, "IM_GCHECKDETAILS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_GCHECKDETAILS\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Guarantee Check</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_GUARANTEE_CHECK\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_GUARANTEE_CHECK\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 7, "IM_MTRANSDETAILS", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_MONEY_TRANSFER_REQ", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Im_Mtransdetails", com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType.class, new com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType(), new java.lang.String[][]{}, "IM_MTRANSDETAILS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_MTRANSDETAILS\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Money Transfer Request</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_MONEY_TRANSFER_REQ\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_MONEY_TRANSFER_REQ\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 8, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 9, "IT_EPSILON_CC_INFO", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Epsilon_Cc_Info", com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List.class, new com.kcdata.abe.bapi.Zepsilon_Cc_FeedType(), new java.lang.String[][]{}, "IT_EPSILON_CC_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_EPSILON_CC_INFO\"><ifr:descriptor><ifr:description language=\"EN\">Epsilon Credit Card Information</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZEPSILON_CC_FEED\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZEPSILON_CC_FEED\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Y_Bapi_Apply_Payment_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Y_Bapi_Apply_Payment_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(8);
    }

    public void setIm_Flag_Gcheck(java.lang.String Im_Flag_Gcheck) {
        baseTypeData().setElementValue(4, Im_Flag_Gcheck);
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(8);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public java.lang.String getIm_Flag_Ccard() {
        return (java.lang.String)baseTypeData().getElementValueAsString(3);
    }

    public void setIm_Application_Info(com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType Im_Application_Info) {
        baseTypeData().setElementValue(0, Im_Application_Info);
    }

    public com.kcdata.abe.bapi.Zapi_Guarantee_CheckType getIm_Gcheckdetails() {
        return (com.kcdata.abe.bapi.Zapi_Guarantee_CheckType)baseTypeData().getElementValue(6);
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(8, It_Return);
    }

    public void setIm_Ccarddetails(com.kcdata.abe.bapi.Zapi_Credit_CardType Im_Ccarddetails) {
        baseTypeData().setElementValue(2, Im_Ccarddetails);
    }

    public com.kcdata.abe.bapi.Zepsilon_Cc_FeedType[] getIt_Epsilon_Cc_Info() {
        com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List i$ = (com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List)baseTypeData().getElementValue(9);
        if ( i$ == null){return null;}
        return  i$.toArrayZepsilon_Cc_FeedType();
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(8, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public MetaData metadataY_Bapi_Apply_Payment_Input() {
        return metadata;
    }

    public com.kcdata.abe.bapi.Zapi_Credit_CardType getIm_Ccarddetails() {
        return (com.kcdata.abe.bapi.Zapi_Credit_CardType)baseTypeData().getElementValue(2);
    }

    public java.lang.String getIm_Bookingnumber() {
        return (java.lang.String)baseTypeData().getElementValueAsString(1);
    }

    public void setIm_Mtransdetails(com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType Im_Mtransdetails) {
        baseTypeData().setElementValue(7, Im_Mtransdetails);
    }

    public java.lang.String getIm_Flag_Gcheck() {
        return (java.lang.String)baseTypeData().getElementValueAsString(4);
    }

    public java.lang.String getIm_Flag_Mtrans() {
        return (java.lang.String)baseTypeData().getElementValueAsString(5);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType getIm_Application_Info() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType)baseTypeData().getElementValue(0);
    }

    public void setIm_Flag_Ccard(java.lang.String Im_Flag_Ccard) {
        baseTypeData().setElementValue(3, Im_Flag_Ccard);
    }

    public void setIm_Gcheckdetails(com.kcdata.abe.bapi.Zapi_Guarantee_CheckType Im_Gcheckdetails) {
        baseTypeData().setElementValue(6, Im_Gcheckdetails);
    }

    public com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType getIm_Mtransdetails() {
        return (com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType)baseTypeData().getElementValue(7);
    }

    public void setIm_Flag_Mtrans(java.lang.String Im_Flag_Mtrans) {
        baseTypeData().setElementValue(5, Im_Flag_Mtrans);
    }

    public void setIt_Epsilon_Cc_Info(com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List It_Epsilon_Cc_Info) {
        baseTypeData().setElementValue(9, It_Epsilon_Cc_Info);
    }

    public void setIm_Bookingnumber(java.lang.String Im_Bookingnumber) {
        baseTypeData().setElementValue(1, Im_Bookingnumber);
    }

    public void setIt_Epsilon_Cc_Info(com.kcdata.abe.bapi.Zepsilon_Cc_FeedType[] It_Epsilon_Cc_Info) {
        baseTypeData().setElementValue(9, new com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List());
        com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List list$ = get_as_listIt_Epsilon_Cc_Info();
        for (int  i$ = 0; i$ < It_Epsilon_Cc_Info.length; i$++){
         list$.addZepsilon_Cc_FeedType(It_Epsilon_Cc_Info[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List get_as_listIt_Epsilon_Cc_Info() {
        return (com.kcdata.abe.bapi.util.Zepsilon_Cc_FeedType_List)baseTypeData().getElementValue(9);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Bapi_Apply_Payment_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Apply_Payment_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Ccarddetails() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Gcheckdetails() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(6);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Bookingnumber() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(8);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Flag_Ccard() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Flag_Gcheck() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Flag_Mtrans() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Application_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Mtransdetails() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(7);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Epsilon_Cc_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(9);
        }
    
    }

}
