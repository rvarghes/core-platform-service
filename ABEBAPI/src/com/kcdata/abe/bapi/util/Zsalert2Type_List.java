package com.kcdata.abe.bapi.util;
public class Zsalert2Type_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 119208649L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:ZSALERT2", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Zsalert2Type.class, new com.kcdata.abe.bapi.Zsalert2Type(), new java.lang.String[][]{}, 98, 196, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"ZSALERT2\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Alert interface</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>98</ifr:internalLength1><ifr:internalLength2>196</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Zsalert2Type_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsZsalert2Type(com.kcdata.abe.bapi.Zsalert2Type item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Zsalert2Type getZsalert2Type(int index) {
        return (com.kcdata.abe.bapi.Zsalert2Type)baseList().get(index);
    }

    public void addAllZsalert2Type(Zsalert2Type_List item) {
        baseList().addAll(item);
    }

    public Zsalert2Type_List subListZsalert2Type(int fromIndex, int toIndex) {
        return (Zsalert2Type_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean removeZsalert2Type(com.kcdata.abe.bapi.Zsalert2Type item) {
        return baseList().remove(item);
    }

    public void addZsalert2Type(com.kcdata.abe.bapi.Zsalert2Type item) {
        baseList().add(item);
    }

    public void addAllZsalert2Type(int index, Zsalert2Type_List item) {
        baseList().addAll(index, item);
    }

    public void addZsalert2Type(int index, com.kcdata.abe.bapi.Zsalert2Type item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Zsalert2Type setZsalert2Type(int index, com.kcdata.abe.bapi.Zsalert2Type item) {
        return (com.kcdata.abe.bapi.Zsalert2Type)baseList().set(index, item);
    }

    public int lastIndexOfZsalert2Type(com.kcdata.abe.bapi.Zsalert2Type item) {
        return baseList().lastIndexOf(item);
    }

    public int indexOfZsalert2Type(com.kcdata.abe.bapi.Zsalert2Type item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Zsalert2Type removeZsalert2Type(int index) {
        return (com.kcdata.abe.bapi.Zsalert2Type)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Zsalert2Type[] toArrayZsalert2Type() {
        return (com.kcdata.abe.bapi.Zsalert2Type[])baseList().toArray(new com.kcdata.abe.bapi.Zsalert2Type[] {});
    }

    public boolean containsAllZsalert2Type(Zsalert2Type_List item) {
        return baseList().containsAll(item);
    }

}
