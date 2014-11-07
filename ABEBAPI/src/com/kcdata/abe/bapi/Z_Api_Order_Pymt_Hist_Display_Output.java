package com.kcdata.abe.bapi;
public class Z_Api_Order_Pymt_Hist_Display_Output extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1279793342562L) ;

    private  Z_Api_Order_Pymt_Hist_Display_Output.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_ORDER_PYMT_HIST_DISPLAY.Output", 4, 0, com.kcdata.abe.bapi.Z_Api_Order_Pymt_Hist_Display_Output.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_ORDER_PYMT_HIST_DISPLAY", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Payment History</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "RETURN", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:BAPIRETURN", "urn:sap-com:document:sap:rfc:functions", false, 0, 1, false, null, "Return", com.kcdata.abe.bapi.BapireturnType.class, new com.kcdata.abe.bapi.BapireturnType(), new java.lang.String[][]{}, "RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.EXPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Message</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRETURN\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRETURN\" /></ifr:definition><ifr:properties><ifr:direction>out</ifr:direction><ifr:class>export</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "MONEYTRANSFERREQ", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Moneytransferreq", com.kcdata.abe.bapi.util.Zapi_Money_Transfer_ReqType_List.class, new com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType(), new java.lang.String[][]{}, "MONEYTRANSFERREQ", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"MONEYTRANSFERREQ\"><ifr:descriptor><ifr:description language=\"EN\">Money Transfer Request Details</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_MONEY_TRANSFER_REQ\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_MONEY_TRANSFER_REQ\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "GUARANTEECHECK", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Guaranteecheck", com.kcdata.abe.bapi.util.Zapi_Guarantee_CheckType_List.class, new com.kcdata.abe.bapi.Zapi_Guarantee_CheckType(), new java.lang.String[][]{}, "GUARANTEECHECK", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"GUARANTEECHECK\"><ifr:descriptor><ifr:description language=\"EN\">Guarantee Check Details</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_GUARANTEE_CHECK\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_GUARANTEE_CHECK\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "CREDITCARDDETAILS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Creditcarddetails", com.kcdata.abe.bapi.util.Zapi_Credit_CardType_List.class, new com.kcdata.abe.bapi.Zapi_Credit_CardType(), new java.lang.String[][]{}, "CREDITCARDDETAILS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"CREDITCARDDETAILS\"><ifr:descriptor><ifr:description language=\"EN\">Credit Card Details</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_CREDIT_CARD\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_CREDIT_CARD\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Z_Api_Order_Pymt_Hist_Display_Output () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Z_Api_Order_Pymt_Hist_Display_Output (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public void setGuaranteecheck(com.kcdata.abe.bapi.util.Zapi_Guarantee_CheckType_List Guaranteecheck) {
        baseTypeData().setElementValue(2, Guaranteecheck);
    }

    public void setGuaranteecheck(com.kcdata.abe.bapi.Zapi_Guarantee_CheckType[] Guaranteecheck) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Zapi_Guarantee_CheckType_List());
        com.kcdata.abe.bapi.util.Zapi_Guarantee_CheckType_List list$ = get_as_listGuaranteecheck();
        for (int  i$ = 0; i$ < Guaranteecheck.length; i$++){
         list$.addZapi_Guarantee_CheckType(Guaranteecheck[ i$]);
        }
    }

    public com.kcdata.abe.bapi.BapireturnType getReturn() {
        return (com.kcdata.abe.bapi.BapireturnType)baseTypeData().getElementValue(0);
    }

    public com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType[] getMoneytransferreq() {
        com.kcdata.abe.bapi.util.Zapi_Money_Transfer_ReqType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Money_Transfer_ReqType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Money_Transfer_ReqType();
    }

    public void setCreditcarddetails(com.kcdata.abe.bapi.Zapi_Credit_CardType[] Creditcarddetails) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Zapi_Credit_CardType_List());
        com.kcdata.abe.bapi.util.Zapi_Credit_CardType_List list$ = get_as_listCreditcarddetails();
        for (int  i$ = 0; i$ < Creditcarddetails.length; i$++){
         list$.addZapi_Credit_CardType(Creditcarddetails[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Zapi_Guarantee_CheckType_List get_as_listGuaranteecheck() {
        return (com.kcdata.abe.bapi.util.Zapi_Guarantee_CheckType_List)baseTypeData().getElementValue(2);
    }

    public com.kcdata.abe.bapi.Zapi_Guarantee_CheckType[] getGuaranteecheck() {
        com.kcdata.abe.bapi.util.Zapi_Guarantee_CheckType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Guarantee_CheckType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Guarantee_CheckType();
    }

    public void setMoneytransferreq(com.kcdata.abe.bapi.Zapi_Money_Transfer_ReqType[] Moneytransferreq) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Zapi_Money_Transfer_ReqType_List());
        com.kcdata.abe.bapi.util.Zapi_Money_Transfer_ReqType_List list$ = get_as_listMoneytransferreq();
        for (int  i$ = 0; i$ < Moneytransferreq.length; i$++){
         list$.addZapi_Money_Transfer_ReqType(Moneytransferreq[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.Zapi_Money_Transfer_ReqType_List get_as_listMoneytransferreq() {
        return (com.kcdata.abe.bapi.util.Zapi_Money_Transfer_ReqType_List)baseTypeData().getElementValue(1);
    }

    public void setReturn(com.kcdata.abe.bapi.BapireturnType Return) {
        baseTypeData().setElementValue(0, Return);
    }

    public void setMoneytransferreq(com.kcdata.abe.bapi.util.Zapi_Money_Transfer_ReqType_List Moneytransferreq) {
        baseTypeData().setElementValue(1, Moneytransferreq);
    }

    public com.kcdata.abe.bapi.util.Zapi_Credit_CardType_List get_as_listCreditcarddetails() {
        return (com.kcdata.abe.bapi.util.Zapi_Credit_CardType_List)baseTypeData().getElementValue(3);
    }

    public com.kcdata.abe.bapi.Zapi_Credit_CardType[] getCreditcarddetails() {
        com.kcdata.abe.bapi.util.Zapi_Credit_CardType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Credit_CardType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Credit_CardType();
    }

    public MetaData metadataZ_Api_Order_Pymt_Hist_Display_Output() {
        return metadata;
    }

    public void setCreditcarddetails(com.kcdata.abe.bapi.util.Zapi_Credit_CardType_List Creditcarddetails) {
        baseTypeData().setElementValue(3, Creditcarddetails);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Order_Pymt_Hist_Display_Output parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Order_Pymt_Hist_Display_Output parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getReturn() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getCreditcarddetails() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getMoneytransferreq() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getGuaranteecheck() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
    }

}
