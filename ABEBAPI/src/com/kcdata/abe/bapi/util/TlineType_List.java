package com.kcdata.abe.bapi.util;
public class TlineType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -313653854L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:TLINE", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.TlineType.class, new com.kcdata.abe.bapi.TlineType(), new java.lang.String[][]{}, 134, 268, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"TLINE\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">SAPscript: Text Lines</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>134</ifr:internalLength1><ifr:internalLength2>268</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  TlineType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addTlineType(com.kcdata.abe.bapi.TlineType item) {
        baseList().add(item);
    }

    public void addAllTlineType(TlineType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.TlineType[] toArrayTlineType() {
        return (com.kcdata.abe.bapi.TlineType[])baseList().toArray(new com.kcdata.abe.bapi.TlineType[] {});
    }

    public void addTlineType(int index, com.kcdata.abe.bapi.TlineType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.TlineType removeTlineType(int index) {
        return (com.kcdata.abe.bapi.TlineType)baseList().remove(index);
    }

    public int lastIndexOfTlineType(com.kcdata.abe.bapi.TlineType item) {
        return baseList().lastIndexOf(item);
    }

    public boolean containsTlineType(com.kcdata.abe.bapi.TlineType item) {
        return baseList().contains(item);
    }

    public boolean containsAllTlineType(TlineType_List item) {
        return baseList().containsAll(item);
    }

    public TlineType_List subListTlineType(int fromIndex, int toIndex) {
        return (TlineType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean removeTlineType(com.kcdata.abe.bapi.TlineType item) {
        return baseList().remove(item);
    }

    public com.kcdata.abe.bapi.TlineType getTlineType(int index) {
        return (com.kcdata.abe.bapi.TlineType)baseList().get(index);
    }

    public int indexOfTlineType(com.kcdata.abe.bapi.TlineType item) {
        return baseList().indexOf(item);
    }

    public void addAllTlineType(int index, TlineType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.TlineType setTlineType(int index, com.kcdata.abe.bapi.TlineType item) {
        return (com.kcdata.abe.bapi.TlineType)baseList().set(index, item);
    }

}
