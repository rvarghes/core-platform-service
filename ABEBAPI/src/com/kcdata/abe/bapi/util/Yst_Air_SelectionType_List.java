package com.kcdata.abe.bapi.util;
public class Yst_Air_SelectionType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -725328916L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_AIR_SELECTION", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Air_SelectionType.class, new com.kcdata.abe.bapi.Yst_Air_SelectionType(), new java.lang.String[][]{}, 16, 32, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_AIR_SELECTION\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Quotation - Air Selection.</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>16</ifr:internalLength1><ifr:internalLength2>32</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Air_SelectionType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public int indexOfYst_Air_SelectionType(com.kcdata.abe.bapi.Yst_Air_SelectionType item) {
        return baseList().indexOf(item);
    }

    public void addYst_Air_SelectionType(int index, com.kcdata.abe.bapi.Yst_Air_SelectionType item) {
        baseList().add(index, item);
    }

    public void addAllYst_Air_SelectionType(int index, Yst_Air_SelectionType_List item) {
        baseList().addAll(index, item);
    }

    public void addAllYst_Air_SelectionType(Yst_Air_SelectionType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Air_SelectionType[] toArrayYst_Air_SelectionType() {
        return (com.kcdata.abe.bapi.Yst_Air_SelectionType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Air_SelectionType[] {});
    }

    public boolean containsAllYst_Air_SelectionType(Yst_Air_SelectionType_List item) {
        return baseList().containsAll(item);
    }

    public int lastIndexOfYst_Air_SelectionType(com.kcdata.abe.bapi.Yst_Air_SelectionType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Air_SelectionType removeYst_Air_SelectionType(int index) {
        return (com.kcdata.abe.bapi.Yst_Air_SelectionType)baseList().remove(index);
    }

    public Yst_Air_SelectionType_List subListYst_Air_SelectionType(int fromIndex, int toIndex) {
        return (Yst_Air_SelectionType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addYst_Air_SelectionType(com.kcdata.abe.bapi.Yst_Air_SelectionType item) {
        baseList().add(item);
    }

    public boolean containsYst_Air_SelectionType(com.kcdata.abe.bapi.Yst_Air_SelectionType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Air_SelectionType getYst_Air_SelectionType(int index) {
        return (com.kcdata.abe.bapi.Yst_Air_SelectionType)baseList().get(index);
    }

    public boolean removeYst_Air_SelectionType(com.kcdata.abe.bapi.Yst_Air_SelectionType item) {
        return baseList().remove(item);
    }

    public com.kcdata.abe.bapi.Yst_Air_SelectionType setYst_Air_SelectionType(int index, com.kcdata.abe.bapi.Yst_Air_SelectionType item) {
        return (com.kcdata.abe.bapi.Yst_Air_SelectionType)baseList().set(index, item);
    }

}
