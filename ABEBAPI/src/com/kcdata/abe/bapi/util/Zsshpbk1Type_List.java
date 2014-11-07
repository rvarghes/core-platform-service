package com.kcdata.abe.bapi.util;
public class Zsshpbk1Type_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -65882272L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZSSHPBK1", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zsshpbk1Type.class, new com.kcdata.abe.bapi.Zsshpbk1Type(), new java.lang.String[][]{}, 701, 1354, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZSSHPBK1\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">FE Shopping Basket Ver 2.</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>701</ifr:internalLength1><ifr:internalLength2>1354</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zsshpbk1Type_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Zsshpbk1Type setZsshpbk1Type(int index, com.kcdata.abe.bapi.Zsshpbk1Type item) {
        return (com.kcdata.abe.bapi.Zsshpbk1Type)baseList().set(index, item);
    }

    public void addZsshpbk1Type(int index, com.kcdata.abe.bapi.Zsshpbk1Type item) {
        baseList().add(index, item);
    }

    public void addAllZsshpbk1Type(Zsshpbk1Type_List item) {
        baseList().addAll(item);
    }

    public boolean removeZsshpbk1Type(com.kcdata.abe.bapi.Zsshpbk1Type item) {
        return baseList().remove(item);
    }

    public boolean containsAllZsshpbk1Type(Zsshpbk1Type_List item) {
        return baseList().containsAll(item);
    }

    public void addZsshpbk1Type(com.kcdata.abe.bapi.Zsshpbk1Type item) {
        baseList().add(item);
    }

    public void addAllZsshpbk1Type(int index, Zsshpbk1Type_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsZsshpbk1Type(com.kcdata.abe.bapi.Zsshpbk1Type item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Zsshpbk1Type getZsshpbk1Type(int index) {
        return (com.kcdata.abe.bapi.Zsshpbk1Type)baseList().get(index);
    }

    public int lastIndexOfZsshpbk1Type(com.kcdata.abe.bapi.Zsshpbk1Type item) {
        return baseList().lastIndexOf(item);
    }

    public Zsshpbk1Type_List subListZsshpbk1Type(int fromIndex, int toIndex) {
        return (Zsshpbk1Type_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Zsshpbk1Type removeZsshpbk1Type(int index) {
        return (com.kcdata.abe.bapi.Zsshpbk1Type)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Zsshpbk1Type[] toArrayZsshpbk1Type() {
        return (com.kcdata.abe.bapi.Zsshpbk1Type[])baseList().toArray(new com.kcdata.abe.bapi.Zsshpbk1Type[] {});
    }

    public int indexOfZsshpbk1Type(com.kcdata.abe.bapi.Zsshpbk1Type item) {
        return baseList().indexOf(item);
    }

}
