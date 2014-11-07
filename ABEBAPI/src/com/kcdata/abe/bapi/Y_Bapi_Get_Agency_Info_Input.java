package com.kcdata.abe.bapi;
public class Y_Bapi_Get_Agency_Info_Input extends com.sap.aii.proxy.framework.core.AbstractType{

    private  static final com.sap.aii.proxy.framework.core.BaseTypeDescriptor staticDescriptor ;

    private  static final com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo = new com.sap.aii.proxy.framework.core.GenerationInfo("2.0", 1286755095453L) ;

    private  Y_Bapi_Get_Agency_Info_Input.MetaData metadata = new MetaData(this) ;

    static {
        com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor = createNewBaseTypeDescriptor(com.sap.aii.proxy.framework.core.XsdlConstants.WSDL_MESSAGE_FOR_JCO, "urn:sap-com:document:sap:rfc:functions", "Y_BAPI_GET_AGENCY_INFO.Input", 5, 0, com.kcdata.abe.bapi.Y_Bapi_Get_Agency_Info_Input.class, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO, "Y_BAPI_GET_AGENCY_INFO", 0, 0, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Get Agency Info</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:package>YABE</ifr:package><ifr:akhNode>HLB0009075</ifr:akhNode><ifr:released>no</ifr:released><ifr:outbound>false</ifr:outbound><ifr:synchronous>true</ifr:synchronous><ifr:asynchronous>false</ifr:asynchronous><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2></ifr:properties><ifr:definition /></ifr:container>");
        descriptorSetElementProperties(descriptor, 0, "IM_APPLICATION_INFO", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_APPLI_INFO", "urn:sap-com:document:sap:rfc:functions", false, 1, 1, false, null, "Im_Application_Info", com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType.class, new com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType(), new java.lang.String[][]{}, "IM_APPLICATION_INFO", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, com.sap.mw.jco.JCO.IMPORT_PARAMETER, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IM_APPLICATION_INFO\"><ifr:descriptor><ifr:description language=\"EN\">BAPI Application Info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_APPLI_INFO\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_APPLI_INFO\" /></ifr:definition><ifr:properties><ifr:direction>in</ifr:direction><ifr:class>import</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 1, "IT_RETURN", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Return", com.kcdata.abe.bapi.util.Bapiret2Type_List.class, new com.kcdata.abe.bapi.Bapiret2Type(), new java.lang.String[][]{}, "IT_RETURN", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_RETURN\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"BAPIRET2\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=BAPIRET2\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 2, "IT_PAYMENTMETHODS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Paymentmethods", com.kcdata.abe.bapi.util.Yst_Bapi_PaymentmethodsType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType(), new java.lang.String[][]{}, "IT_PAYMENTMETHODS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_PAYMENTMETHODS\"><ifr:descriptor><ifr:description language=\"EN\">Payment Methods for an Agency</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_PAYMENTMETHODS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_PAYMENTMETHODS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 3, "IT_CONTACT_PERSONS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Contact_Persons", com.kcdata.abe.bapi.util.Yst_Bapi_Contact_PersonType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType(), new java.lang.String[][]{}, "IT_CONTACT_PERSONS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_CONTACT_PERSONS\"><ifr:descriptor><ifr:description language=\"EN\">Agency Data</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_CONTACT_PERSON\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_CONTACT_PERSON\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        descriptorSetElementProperties(descriptor, 4, "IT_ACCEPTED_CARDS", null, null, "unqualified", null, "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "It_Accepted_Cards", com.kcdata.abe.bapi.util.Yst_Bapi_CreditcardsType_List.class, new com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType(), new java.lang.String[][]{}, "IT_ACCEPTED_CARDS", 0, 0, -1, -1, -1, -1, com.sap.mw.jco.JCO.TYPE_TABLE, 0, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ifr:parameter name=\"IT_ACCEPTED_CARDS\"><ifr:descriptor><ifr:description language=\"EN\">Agency Credit card info</ifr:description></ifr:descriptor><ifr:definition><ifr:complexType name=\"YST_BAPI_CREDITCARDS\" type=\"structure\" xlink:role=\"type\" xlink:href=\"/Content?TYPE=type&amp;NAME=YST_BAPI_CREDITCARDS\" /></ifr:definition><ifr:properties><ifr:direction>inout</ifr:direction><ifr:class>tables</ifr:class><ifr:type>structure</ifr:type><ifr:optional>false</ifr:optional><ifr:basedOnDictionaryReference>true</ifr:basedOnDictionaryReference></ifr:properties></ifr:parameter>");
        staticDescriptor = descriptor;
    }
    public  Y_Bapi_Get_Agency_Info_Input () {
        super(staticDescriptor, staticGenerationInfo, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    protected  Y_Bapi_Get_Agency_Info_Input (com.sap.aii.proxy.framework.core.BaseTypeDescriptor descriptor, com.sap.aii.proxy.framework.core.GenerationInfo staticGenerationInfo, int connectionType) {
        super(descriptor, staticGenerationInfo, connectionType);
    }

    public com.kcdata.abe.bapi.util.Bapiret2Type_List get_as_listIt_Return() {
        return (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(1);
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_PaymentmethodsType_List get_as_listIt_Paymentmethods() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_PaymentmethodsType_List)baseTypeData().getElementValue(2);
    }

    public com.kcdata.abe.bapi.Bapiret2Type[] getIt_Return() {
        com.kcdata.abe.bapi.util.Bapiret2Type_List i$ = (com.kcdata.abe.bapi.util.Bapiret2Type_List)baseTypeData().getElementValue(1);
        if ( i$ == null){return null;}
        return  i$.toArrayBapiret2Type();
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_Contact_PersonType_List get_as_listIt_Contact_Persons() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_Contact_PersonType_List)baseTypeData().getElementValue(3);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType getIm_Application_Info() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType)baseTypeData().getElementValue(0);
    }

    public void setIm_Application_Info(com.kcdata.abe.bapi.Yst_Bapi_Appli_InfoType Im_Application_Info) {
        baseTypeData().setElementValue(0, Im_Application_Info);
    }

    public void setIt_Paymentmethods(com.kcdata.abe.bapi.util.Yst_Bapi_PaymentmethodsType_List It_Paymentmethods) {
        baseTypeData().setElementValue(2, It_Paymentmethods);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType[] getIt_Paymentmethods() {
        com.kcdata.abe.bapi.util.Yst_Bapi_PaymentmethodsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_PaymentmethodsType_List)baseTypeData().getElementValue(2);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_PaymentmethodsType();
    }

    public void setIt_Accepted_Cards(com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType[] It_Accepted_Cards) {
        baseTypeData().setElementValue(4, new com.kcdata.abe.bapi.util.Yst_Bapi_CreditcardsType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_CreditcardsType_List list$ = get_as_listIt_Accepted_Cards();
        for (int  i$ = 0; i$ < It_Accepted_Cards.length; i$++){
         list$.addYst_Bapi_CreditcardsType(It_Accepted_Cards[ i$]);
        }
    }

    public MetaData metadataY_Bapi_Get_Agency_Info_Input() {
        return metadata;
    }

    public void setIt_Accepted_Cards(com.kcdata.abe.bapi.util.Yst_Bapi_CreditcardsType_List It_Accepted_Cards) {
        baseTypeData().setElementValue(4, It_Accepted_Cards);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_CreditcardsType[] getIt_Accepted_Cards() {
        com.kcdata.abe.bapi.util.Yst_Bapi_CreditcardsType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_CreditcardsType_List)baseTypeData().getElementValue(4);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_CreditcardsType();
    }

    public void setIt_Contact_Persons(com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType[] It_Contact_Persons) {
        baseTypeData().setElementValue(3, new com.kcdata.abe.bapi.util.Yst_Bapi_Contact_PersonType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_Contact_PersonType_List list$ = get_as_listIt_Contact_Persons();
        for (int  i$ = 0; i$ < It_Contact_Persons.length; i$++){
         list$.addYst_Bapi_Contact_PersonType(It_Contact_Persons[ i$]);
        }
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Contact_PersonType[] getIt_Contact_Persons() {
        com.kcdata.abe.bapi.util.Yst_Bapi_Contact_PersonType_List i$ = (com.kcdata.abe.bapi.util.Yst_Bapi_Contact_PersonType_List)baseTypeData().getElementValue(3);
        if ( i$ == null){return null;}
        return  i$.toArrayYst_Bapi_Contact_PersonType();
    }

    public void setIt_Return(com.kcdata.abe.bapi.util.Bapiret2Type_List It_Return) {
        baseTypeData().setElementValue(1, It_Return);
    }

    public void setIt_Paymentmethods(com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType[] It_Paymentmethods) {
        baseTypeData().setElementValue(2, new com.kcdata.abe.bapi.util.Yst_Bapi_PaymentmethodsType_List());
        com.kcdata.abe.bapi.util.Yst_Bapi_PaymentmethodsType_List list$ = get_as_listIt_Paymentmethods();
        for (int  i$ = 0; i$ < It_Paymentmethods.length; i$++){
         list$.addYst_Bapi_PaymentmethodsType(It_Paymentmethods[ i$]);
        }
    }

    public void setIt_Contact_Persons(com.kcdata.abe.bapi.util.Yst_Bapi_Contact_PersonType_List It_Contact_Persons) {
        baseTypeData().setElementValue(3, It_Contact_Persons);
    }

    public com.kcdata.abe.bapi.util.Yst_Bapi_CreditcardsType_List get_as_listIt_Accepted_Cards() {
        return (com.kcdata.abe.bapi.util.Yst_Bapi_CreditcardsType_List)baseTypeData().getElementValue(4);
    }

    public void setIt_Return(com.kcdata.abe.bapi.Bapiret2Type[] It_Return) {
        baseTypeData().setElementValue(1, new com.kcdata.abe.bapi.util.Bapiret2Type_List());
        com.kcdata.abe.bapi.util.Bapiret2Type_List list$ = get_as_listIt_Return();
        for (int  i$ = 0; i$ < It_Return.length; i$++){
         list$.addBapiret2Type(It_Return[ i$]);
        }
    }

    public static class MetaData implements java.io.Serializable {
    
        private  Y_Bapi_Get_Agency_Info_Input parent ;
    
        private  static final long serialVersionUID = -386313361L ;
    
        protected  MetaData (Y_Bapi_Get_Agency_Info_Input parent) {
            this.parent = parent;
            
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Return() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(1);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Accepted_Cards() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(4);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Contact_Persons() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(3);
        }
    
        public com.sap.aii.proxy.framework.core.TypeMetaData typeMetadata() {
            return (com.sap.aii.proxy.framework.core.TypeMetaData)parent.baseTypeMetaData();
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIt_Paymentmethods() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(2);
        }
    
        public com.sap.aii.proxy.framework.core.JcoMetaData getIm_Application_Info() {
            return (com.sap.aii.proxy.framework.core.JcoMetaData)parent.baseTypeMetaData().getElement(0);
        }
    
    }

}
