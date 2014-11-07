package com.kcdata.abe.bapi.util;
public class Zapi_Credit_Card1Type_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1122810092L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZAPI_CREDIT_CARD1", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zapi_Credit_Card1Type.class, new com.kcdata.abe.bapi.Zapi_Credit_Card1Type(), new java.lang.String[][]{}, 318, 624, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZAPI_CREDIT_CARD1\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Structure for Credit Card Payment</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>318</ifr:internalLength1><ifr:internalLength2>624</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zapi_Credit_Card1Type_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public Zapi_Credit_Card1Type_List subListZapi_Credit_Card1Type(int fromIndex, int toIndex) {
        return (Zapi_Credit_Card1Type_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Zapi_Credit_Card1Type getZapi_Credit_Card1Type(int index) {
        return (com.kcdata.abe.bapi.Zapi_Credit_Card1Type)baseList().get(index);
    }

    public int indexOfZapi_Credit_Card1Type(com.kcdata.abe.bapi.Zapi_Credit_Card1Type item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Zapi_Credit_Card1Type removeZapi_Credit_Card1Type(int index) {
        return (com.kcdata.abe.bapi.Zapi_Credit_Card1Type)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Zapi_Credit_Card1Type setZapi_Credit_Card1Type(int index, com.kcdata.abe.bapi.Zapi_Credit_Card1Type item) {
        return (com.kcdata.abe.bapi.Zapi_Credit_Card1Type)baseList().set(index, item);
    }

    public void addZapi_Credit_Card1Type(int index, com.kcdata.abe.bapi.Zapi_Credit_Card1Type item) {
        baseList().add(index, item);
    }

    public void addAllZapi_Credit_Card1Type(int index, Zapi_Credit_Card1Type_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Zapi_Credit_Card1Type[] toArrayZapi_Credit_Card1Type() {
        return (com.kcdata.abe.bapi.Zapi_Credit_Card1Type[])baseList().toArray(new com.kcdata.abe.bapi.Zapi_Credit_Card1Type[] {});
    }

    public int lastIndexOfZapi_Credit_Card1Type(com.kcdata.abe.bapi.Zapi_Credit_Card1Type item) {
        return baseList().lastIndexOf(item);
    }

    public boolean removeZapi_Credit_Card1Type(com.kcdata.abe.bapi.Zapi_Credit_Card1Type item) {
        return baseList().remove(item);
    }

    public void addZapi_Credit_Card1Type(com.kcdata.abe.bapi.Zapi_Credit_Card1Type item) {
        baseList().add(item);
    }

    public boolean containsZapi_Credit_Card1Type(com.kcdata.abe.bapi.Zapi_Credit_Card1Type item) {
        return baseList().contains(item);
    }

    public void addAllZapi_Credit_Card1Type(Zapi_Credit_Card1Type_List item) {
        baseList().addAll(item);
    }

    public boolean containsAllZapi_Credit_Card1Type(Zapi_Credit_Card1Type_List item) {
        return baseList().containsAll(item);
    }

}
