package com.kcdata.abe.bapi.util;
public class Yst_LocinfoType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 587481059L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_LOCINFO", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_LocinfoType.class, new com.kcdata.abe.bapi.Yst_LocinfoType(), new java.lang.String[][]{}, 438, 862, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_LOCINFO\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Geographical Situation Location Information</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>438</ifr:internalLength1><ifr:internalLength2>862</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_LocinfoType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addAllYst_LocinfoType(Yst_LocinfoType_List item) {
        baseList().addAll(item);
    }

    public boolean containsYst_LocinfoType(com.kcdata.abe.bapi.Yst_LocinfoType item) {
        return baseList().contains(item);
    }

    public boolean removeYst_LocinfoType(com.kcdata.abe.bapi.Yst_LocinfoType item) {
        return baseList().remove(item);
    }

    public void addAllYst_LocinfoType(int index, Yst_LocinfoType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Yst_LocinfoType[] toArrayYst_LocinfoType() {
        return (com.kcdata.abe.bapi.Yst_LocinfoType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_LocinfoType[] {});
    }

    public com.kcdata.abe.bapi.Yst_LocinfoType setYst_LocinfoType(int index, com.kcdata.abe.bapi.Yst_LocinfoType item) {
        return (com.kcdata.abe.bapi.Yst_LocinfoType)baseList().set(index, item);
    }

    public Yst_LocinfoType_List subListYst_LocinfoType(int fromIndex, int toIndex) {
        return (Yst_LocinfoType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean containsAllYst_LocinfoType(Yst_LocinfoType_List item) {
        return baseList().containsAll(item);
    }

    public void addYst_LocinfoType(com.kcdata.abe.bapi.Yst_LocinfoType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Yst_LocinfoType getYst_LocinfoType(int index) {
        return (com.kcdata.abe.bapi.Yst_LocinfoType)baseList().get(index);
    }

    public int indexOfYst_LocinfoType(com.kcdata.abe.bapi.Yst_LocinfoType item) {
        return baseList().indexOf(item);
    }

    public void addYst_LocinfoType(int index, com.kcdata.abe.bapi.Yst_LocinfoType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Yst_LocinfoType removeYst_LocinfoType(int index) {
        return (com.kcdata.abe.bapi.Yst_LocinfoType)baseList().remove(index);
    }

    public int lastIndexOfYst_LocinfoType(com.kcdata.abe.bapi.Yst_LocinfoType item) {
        return baseList().lastIndexOf(item);
    }

}
