package com.kcdata.abe.bapi.util;
public class BapireturnType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1510819106L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:BAPIRETURN", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.BapireturnType.class, new com.kcdata.abe.bapi.BapireturnType(), new java.lang.String[][]{}, 452, 904, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"BAPIRETURN\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Return Parameter</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>452</ifr:internalLength1><ifr:internalLength2>904</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  BapireturnType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsBapireturnType(com.kcdata.abe.bapi.BapireturnType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.BapireturnType getBapireturnType(int index) {
        return (com.kcdata.abe.bapi.BapireturnType)baseList().get(index);
    }

    public boolean containsAllBapireturnType(BapireturnType_List item) {
        return baseList().containsAll(item);
    }

    public void addBapireturnType(int index, com.kcdata.abe.bapi.BapireturnType item) {
        baseList().add(index, item);
    }

    public void addAllBapireturnType(BapireturnType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.BapireturnType removeBapireturnType(int index) {
        return (com.kcdata.abe.bapi.BapireturnType)baseList().remove(index);
    }

    public void addBapireturnType(com.kcdata.abe.bapi.BapireturnType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.BapireturnType setBapireturnType(int index, com.kcdata.abe.bapi.BapireturnType item) {
        return (com.kcdata.abe.bapi.BapireturnType)baseList().set(index, item);
    }

    public int indexOfBapireturnType(com.kcdata.abe.bapi.BapireturnType item) {
        return baseList().indexOf(item);
    }

    public int lastIndexOfBapireturnType(com.kcdata.abe.bapi.BapireturnType item) {
        return baseList().lastIndexOf(item);
    }

    public BapireturnType_List subListBapireturnType(int fromIndex, int toIndex) {
        return (BapireturnType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean removeBapireturnType(com.kcdata.abe.bapi.BapireturnType item) {
        return baseList().remove(item);
    }

    public void addAllBapireturnType(int index, BapireturnType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.BapireturnType[] toArrayBapireturnType() {
        return (com.kcdata.abe.bapi.BapireturnType[])baseList().toArray(new com.kcdata.abe.bapi.BapireturnType[] {});
    }

}
