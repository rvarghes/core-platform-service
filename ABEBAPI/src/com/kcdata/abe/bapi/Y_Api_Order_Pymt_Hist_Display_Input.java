package com.kcdata.abe.bapi;
public class Y_Api_Order_Pymt_Hist_Display_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1280932265859L) ;

    private  Y_Api_Order_Pymt_Hist_Display_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_API_ORDER_PYMT_HIST_DISPLAY.Input", 2, 0, com.kcdata.abe.bapi.Y_Api_Order_Pymt_Hist_Display_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_API_ORDER_PYMT_HIST_DISPLAY", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Payment History</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "DOCUMENTNUMBER", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Documentnumber", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "DOCUMENTNUMBER", 0, 0, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"DOCUMENTNUMBER\"><ifr:descriptor><ifr:description language=\"EN\">Document Number</ifr:description></ifr:descriptor><ifr:definition><ifr:field name=\"VBAK.VBELN\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:checkTable>VBUK</ifr:checkTable><ifr:offset1>3</ifr:offset1><ifr:offset2>6</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"VBELN_VA\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength><ifr:conversionExit>ALPHA</ifr:conversionExit></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "PAYMENTSTODATE", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Paymentstodate", com.kcdata.abe.bapi.util.Zapi_Tourop_Itn_PaytodateType_List.class, new com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType(), new java.lang.String[][]{}, "PAYMENTSTODATE", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"PAYMENTSTODATE\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Itinerary Payments to Date</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"ZAPI_TOUROP_ITN_PAYTODATE\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZAPI_TOUROP_ITN_PAYTODATE\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Y_Api_Order_Pymt_Hist_Display_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Y_Api_Order_Pymt_Hist_Display_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.util.Zapi_Tourop_Itn_PaytodateType_List get_as_listPaymentstodate() {
        return (com.kcdata.abe.bapi.util.Zapi_Tourop_Itn_PaytodateType_List)baseTypeData().getElementValue(1);
    }

    public java.lang.String getDocumentnumber() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public void setDocumentnumber(java.lang.String Documentnumber) {
        baseTypeData().setElementValue(0, Documentnumber);
    }

    public void setPaymentstodate(com.kcdata.abe.bapi.util.Zapi_Tourop_Itn_PaytodateType_List Paymentstodate) {
        baseTypeData().setElementValue(1, Paymentstodate);
    }

    public void setPaymentstodate(com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType[] Paymentstodate) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Zapi_Tourop_Itn_PaytodateType_List());
        com.kcdata.abe.bapi.util.Zapi_Tourop_Itn_PaytodateType_List list$ = get_as_listPaymentstodate();
        for (int  i$ = 0; i$ < Paymentstodate.length; i$++){
         list$.addZapi_Tourop_Itn_PaytodateType(Paymentstodate[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Zapi_Tourop_Itn_PaytodateType[] getPaymentstodate() {
        com.kcdata.abe.bapi.util.Zapi_Tourop_Itn_PaytodateType_List i$ = (com.kcdata.abe.bapi.util.Zapi_Tourop_Itn_PaytodateType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayZapi_Tourop_Itn_PaytodateType();
    }

    public MetaData metadataY_Api_Order_Pymt_Hist_Display_Input() {
        return metadata;
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Api_Order_Pymt_Hist_Display_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Api_Order_Pymt_Hist_Display_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getDocumentnumber() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getPaymentstodate() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
    }

}
