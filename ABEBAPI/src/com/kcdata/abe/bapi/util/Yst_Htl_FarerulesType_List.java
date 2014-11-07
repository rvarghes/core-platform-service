package com.kcdata.abe.bapi.util;
public class Yst_Htl_FarerulesType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -2025578881L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_HTL_FARERULES", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Htl_FarerulesType.class, new com.kcdata.abe.bapi.Yst_Htl_FarerulesType(), new java.lang.String[][]{}, 134, 268, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_HTL_FARERULES\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">WS Hotel Fare rules</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>134</ifr:internalLength1><ifr:internalLength2>268</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Htl_FarerulesType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public boolean containsAllYst_Htl_FarerulesType(Yst_Htl_FarerulesType_List item) {
        return baseList().containsAll(item);
    }

    public boolean containsYst_Htl_FarerulesType(com.kcdata.abe.bapi.Yst_Htl_FarerulesType item) {
        return baseList().contains(item);
    }

    public void addAllYst_Htl_FarerulesType(int index, Yst_Htl_FarerulesType_List item) {
        baseList().addAll(index, item);
    }

    public void addYst_Htl_FarerulesType(int index, com.kcdata.abe.bapi.Yst_Htl_FarerulesType item) {
        baseList().add(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_FarerulesType getYst_Htl_FarerulesType(int index) {
        return (com.kcdata.abe.bapi.Yst_Htl_FarerulesType)baseList().get(index);
    }

    public boolean removeYst_Htl_FarerulesType(com.kcdata.abe.bapi.Yst_Htl_FarerulesType item) {
        return baseList().remove(item);
    }

    public Yst_Htl_FarerulesType_List subListYst_Htl_FarerulesType(int fromIndex, int toIndex) {
        return (Yst_Htl_FarerulesType_List)baseList().subList(fromIndex, toIndex);
    }

    public int indexOfYst_Htl_FarerulesType(com.kcdata.abe.bapi.Yst_Htl_FarerulesType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_FarerulesType removeYst_Htl_FarerulesType(int index) {
        return (com.kcdata.abe.bapi.Yst_Htl_FarerulesType)baseList().remove(index);
    }

    public void addYst_Htl_FarerulesType(com.kcdata.abe.bapi.Yst_Htl_FarerulesType item) {
        baseList().add(item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_FarerulesType setYst_Htl_FarerulesType(int index, com.kcdata.abe.bapi.Yst_Htl_FarerulesType item) {
        return (com.kcdata.abe.bapi.Yst_Htl_FarerulesType)baseList().set(index, item);
    }

    public int lastIndexOfYst_Htl_FarerulesType(com.kcdata.abe.bapi.Yst_Htl_FarerulesType item) {
        return baseList().lastIndexOf(item);
    }

    public void addAllYst_Htl_FarerulesType(Yst_Htl_FarerulesType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_FarerulesType[] toArrayYst_Htl_FarerulesType() {
        return (com.kcdata.abe.bapi.Yst_Htl_FarerulesType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Htl_FarerulesType[] {});
    }

}
