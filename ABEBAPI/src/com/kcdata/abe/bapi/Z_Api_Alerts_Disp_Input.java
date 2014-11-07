package com.kcdata.abe.bapi;
public class Z_Api_Alerts_Disp_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1318915545198L) ;

    private  Z_Api_Alerts_Disp_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Z_API_ALERTS_DISP.Input", 6, 0, com.kcdata.abe.bapi.Z_Api_Alerts_Disp_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Z_API_ALERTS_DISP", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Alerts and address display on itinerary</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>ZAPI</ifr:package><ifr:akhNode>HLB0009009</ifr:akhNode><ifr:released>external</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "BOOKINGNO", null, null, "unqualified", "http://www.w3.org/2001/XMLSchema:string", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Bookingno", java.lang.String.class, null, new java.lang.String[][]{{"maxLength", "10"}}, "BOOKINGNO", 0, 0, -1, 10, 20, -1, com.sap.mw.jco.JCO.TYPE_CHAR, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"BOOKINGNO\"><ifr:descriptor /><ifr:definition><ifr:field name=\"VBAK.VBELN\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:checkTable>VBUK</ifr:checkTable><ifr:offset1>3</ifr:offset1><ifr:offset2>6</ifr:offset2></ifr:properties></ifr:field><ifr:scalarType name=\"VBELN_VA\"><ifr:properties><ifr:helpValuesSupported>true</ifr:helpValuesSupported><ifr:fixedValuesListDefined>false</ifr:fixedValuesListDefined><ifr:mixedCaseSupported>false</ifr:mixedCaseSupported><ifr:signedNumber>false</ifr:signedNumber></ifr:properties><ifr:definition><ifr:type>CHAR</ifr:type><ifr:abapType>C</ifr:abapType><ifr:length>10</ifr:length><ifr:internalLength1>10</ifr:internalLength1><ifr:internalLength2>20</ifr:internalLength2><ifr:decimals>0</ifr:decimals><ifr:outputLength>10</ifr:outputLength><ifr:conversionExit>ALPHA</ifr:conversionExit></ifr:definition></ifr:scalarType></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>scalar</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IT_VPC", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Vpc", com.kcdata.abe.bapi.util.YsvpromocType_List.class, new com.kcdata.abe.bapi.YsvpromocType(), new java.lang.String[][]{}, "IT_VPC", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_VPC\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"YSVPROMOC\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YSVPROMOC\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IT_VMESSAGE", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Vmessage", com.kcdata.abe.bapi.util.ZsalertType_List.class, new com.kcdata.abe.bapi.ZsalertType(), new java.lang.String[][]{}, "IT_VMESSAGE", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_VMESSAGE\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZSALERT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZSALERT\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IT_OUTPUT", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Output", com.kcdata.abe.bapi.util.ZsalertType_List.class, new com.kcdata.abe.bapi.ZsalertType(), new java.lang.String[][]{}, "IT_OUTPUT", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_OUTPUT\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZSALERT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZSALERT\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IT_ALERT", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Alert", com.kcdata.abe.bapi.util.ZsalertType_List.class, new com.kcdata.abe.bapi.ZsalertType(), new java.lang.String[][]{}, "IT_ALERT", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_ALERT\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZSALERT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZSALERT\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 5, "IT_AGADV", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Agadv", com.kcdata.abe.bapi.util.ZsalertType_List.class, new com.kcdata.abe.bapi.ZsalertType(), new java.lang.String[][]{}, "IT_AGADV", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_AGADV\"><ifr:descriptor /><ifr:definition><ifr:complexType name=\"ZSALERT\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=ZSALERT\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>true</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    protected  Z_Api_Alerts_Disp_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public  Z_Api_Alerts_Disp_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void setIt_Agadv(com.kcdata.abe.bapi.util.ZsalertType_List It_Agadv) {
        baseTypeData().setElementValue(5, It_Agadv);
    }

    public void setIt_Alert(com.kcdata.abe.bapi.ZsalertType[] It_Alert) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.ZsalertType_List());
        com.kcdata.abe.bapi.util.ZsalertType_List list$ = get_as_listIt_Alert();
        for (int  i$ = 0; i$ < It_Alert.length; i$++){
         list$.addZsalertType(It_Alert[ i$]);
        }
    }

    public com.kcdata.abe.bapi.util.YsvpromocType_List get_as_listIt_Vpc() {
        return (com.kcdata.abe.bapi.util.YsvpromocType_List)baseTypeData().getElementValue(1);
    }

    public void setBookingno(java.lang.String Bookingno) {
        baseTypeData().setElementValue(0, Bookingno);
    }

    public com.kcdata.abe.bapi.util.ZsalertType_List get_as_listIt_Output() {
        return (com.kcdata.abe.bapi.util.ZsalertType_List)baseTypeData().getElementValue(3);
    }

    public void setIt_Vmessage(com.kcdata.abe.bapi.util.ZsalertType_List It_Vmessage) {
        baseTypeData().setElementValue(2, It_Vmessage);
    }

    public com.kcdata.abe.bapi.ZsalertType[] getIt_Agadv() {
        com.kcdata.abe.bapi.util.ZsalertType_List i$ = (com.kcdata.abe.bapi.util.ZsalertType_List)baseTypeData().getElementValue(5);
        if ( i$ == null){return null;}
        return  i$.toArrayZsalertType();
    }

    public void setIt_Output(com.kcdata.abe.bapi.ZsalertType[] It_Output) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.ZsalertType_List());
        com.kcdata.abe.bapi.util.ZsalertType_List list$ = get_as_listIt_Output();
        for (int  i$ = 0; i$ < It_Output.length; i$++){
         list$.addZsalertType(It_Output[ i$]);
        }
    }

    public com.kcdata.abe.bapi.ZsalertType[] getIt_Vmessage() {
        com.kcdata.abe.bapi.util.ZsalertType_List i$ = (com.kcdata.abe.bapi.util.ZsalertType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayZsalertType();
    }

    public void setIt_Alert(com.kcdata.abe.bapi.util.ZsalertType_List It_Alert) {
        baseTypeData().setElementValue(4, It_Alert);
    }

    public void setIt_Vpc(com.kcdata.abe.bapi.util.YsvpromocType_List It_Vpc) {
        baseTypeData().setElementValue(1, It_Vpc);
    }

    public com.kcdata.abe.bapi.YsvpromocType[] getIt_Vpc() {
        com.kcdata.abe.bapi.util.YsvpromocType_List i$ = (com.kcdata.abe.bapi.util.YsvpromocType_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayYsvpromocType();
    }

    public com.kcdata.abe.bapi.util.ZsalertType_List get_as_listIt_Alert() {
        return (com.kcdata.abe.bapi.util.ZsalertType_List)baseTypeData().getElementValue(4);
    }

    public void setIt_Agadv(com.kcdata.abe.bapi.ZsalertType[] It_Agadv) {
        baseTypeData().setElementValue(5, new com.kcdata.abe.bapi.util.ZsalertType_List());
        com.kcdata.abe.bapi.util.ZsalertType_List list$ = get_as_listIt_Agadv();
        for (int  i$ = 0; i$ < It_Agadv.length; i$++){
         list$.addZsalertType(It_Agadv[ i$]);
        }
    }

    public java.lang.String getBookingno() {
        return (java.lang.String)baseTypeData().getElementValueAsString(0);
    }

    public com.kcdata.abe.bapi.util.ZsalertType_List get_as_listIt_Vmessage() {
        return (com.kcdata.abe.bapi.util.ZsalertType_List)baseTypeData().getElementValue(2);
    }

    public void setIt_Output(com.kcdata.abe.bapi.util.ZsalertType_List It_Output) {
        baseTypeData().setElementValue(3, It_Output);
    }

    public com.kcdata.abe.bapi.ZsalertType[] getIt_Output() {
        com.kcdata.abe.bapi.util.ZsalertType_List i$ = (com.kcdata.abe.bapi.util.ZsalertType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayZsalertType();
    }

    public void setIt_Vmessage(com.kcdata.abe.bapi.ZsalertType[] It_Vmessage) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.ZsalertType_List());
        com.kcdata.abe.bapi.util.ZsalertType_List list$ = get_as_listIt_Vmessage();
        for (int  i$ = 0; i$ < It_Vmessage.length; i$++){
         list$.addZsalertType(It_Vmessage[ i$]);
        }
    }

    public com.kcdata.abe.bapi.ZsalertType[] getIt_Alert() {
        com.kcdata.abe.bapi.util.ZsalertType_List i$ = (com.kcdata.abe.bapi.util.ZsalertType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayZsalertType();
    }

    public void setIt_Vpc(com.kcdata.abe.bapi.YsvpromocType[] It_Vpc) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.YsvpromocType_List());
        com.kcdata.abe.bapi.util.YsvpromocType_List list$ = get_as_listIt_Vpc();
        for (int  i$ = 0; i$ < It_Vpc.length; i$++){
         list$.addYsvpromocType(It_Vpc[ i$]);
        }
    }

    public MetaData metadataZ_Api_Alerts_Disp_Input() {
        return metadata;
    }

    public com.kcdata.abe.bapi.util.ZsalertType_List get_as_listIt_Agadv() {
        return (com.kcdata.abe.bapi.util.ZsalertType_List)baseTypeData().getElementValue(5);
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Z_Api_Alerts_Disp_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Z_Api_Alerts_Disp_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getBookingno() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Agadv() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(5);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Output() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Vmessage() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Alert() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Vpc() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
    }

}
