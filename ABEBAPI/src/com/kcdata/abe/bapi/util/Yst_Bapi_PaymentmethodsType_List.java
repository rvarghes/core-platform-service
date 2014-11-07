package com.kcdata.abe.bapi.util;
public class Yst_Bapi_PaymentmethodsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -643090264L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_PAYMENTMETHODS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType.class, new com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType(), new java.lang.String[][]{}, 31, 62, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_PAYMENTMETHODS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Payment Methods for an Agency</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>31</ifr:internalLength1><ifr:internalLength2>62</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_PaymentmethodsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addYst_Bapi_PaymentmethodsType(int index, com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType item) {
        baseList().add(index, item);
    }

    public Yst_Bapi_PaymentmethodsType_List subListYst_Bapi_PaymentmethodsType(int fromIndex, int toIndex) {
        return (Yst_Bapi_PaymentmethodsType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllYst_Bapi_PaymentmethodsType(Yst_Bapi_PaymentmethodsType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYst_Bapi_PaymentmethodsType(com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType item) {
        return baseList().remove(item);
    }

    public boolean containsYst_Bapi_PaymentmethodsType(com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType item) {
        return baseList().contains(item);
    }

    public int indexOfYst_Bapi_PaymentmethodsType(com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType setYst_Bapi_PaymentmethodsType(int index, com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType)baseList().set(index, item);
    }

    public boolean containsAllYst_Bapi_PaymentmethodsType(Yst_Bapi_PaymentmethodsType_List item) {
        return baseList().containsAll(item);
    }

    public void addAllYst_Bapi_PaymentmethodsType(int index, Yst_Bapi_PaymentmethodsType_List item) {
        baseList().addAll(index, item);
    }

    public int lastIndexOfYst_Bapi_PaymentmethodsType(com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType[] toArrayYst_Bapi_PaymentmethodsType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType[] {});
    }

    public com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType getYst_Bapi_PaymentmethodsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType)baseList().get(index);
    }

    public void addYst_Bapi_PaymentmethodsType(com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType removeYst_Bapi_PaymentmethodsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_PaymentmethodsType)baseList().remove(index);
    }

}
