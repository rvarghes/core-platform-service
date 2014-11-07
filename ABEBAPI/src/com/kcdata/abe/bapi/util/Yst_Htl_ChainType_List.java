package com.kcdata.abe.bapi.util;
public class Yst_Htl_ChainType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1218008649L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_HTL_CHAIN", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Htl_ChainType.class, new com.kcdata.abe.bapi.Yst_Htl_ChainType(), new java.lang.String[][]{}, 30, 60, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_HTL_CHAIN\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Hotel chain data</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>30</ifr:internalLength1><ifr:internalLength2>60</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Htl_ChainType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addAllYst_Htl_ChainType(int index, Yst_Htl_ChainType_List item) {
        baseList().addAll(index, item);
    }

    public void addYst_Htl_ChainType(com.kcdata.abe.bapi.Yst_Htl_ChainType item) {
        baseList().add(item);
    }

    public Yst_Htl_ChainType_List subListYst_Htl_ChainType(int fromIndex, int toIndex) {
        return (Yst_Htl_ChainType_List)baseList().subList(fromIndex, toIndex);
    }

    public com.kcdata.abe.bapi.Yst_Htl_ChainType getYst_Htl_ChainType(int index) {
        return (com.kcdata.abe.bapi.Yst_Htl_ChainType)baseList().get(index);
    }

    public boolean containsYst_Htl_ChainType(com.kcdata.abe.bapi.Yst_Htl_ChainType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_ChainType removeYst_Htl_ChainType(int index) {
        return (com.kcdata.abe.bapi.Yst_Htl_ChainType)baseList().remove(index);
    }

    public void addAllYst_Htl_ChainType(Yst_Htl_ChainType_List item) {
        baseList().addAll(item);
    }

    public int lastIndexOfYst_Htl_ChainType(com.kcdata.abe.bapi.Yst_Htl_ChainType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_ChainType setYst_Htl_ChainType(int index, com.kcdata.abe.bapi.Yst_Htl_ChainType item) {
        return (com.kcdata.abe.bapi.Yst_Htl_ChainType)baseList().set(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_ChainType[] toArrayYst_Htl_ChainType() {
        return (com.kcdata.abe.bapi.Yst_Htl_ChainType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Htl_ChainType[] {});
    }

    public void addYst_Htl_ChainType(int index, com.kcdata.abe.bapi.Yst_Htl_ChainType item) {
        baseList().add(index, item);
    }

    public int indexOfYst_Htl_ChainType(com.kcdata.abe.bapi.Yst_Htl_ChainType item) {
        return baseList().indexOf(item);
    }

    public boolean containsAllYst_Htl_ChainType(Yst_Htl_ChainType_List item) {
        return baseList().containsAll(item);
    }

    public boolean removeYst_Htl_ChainType(com.kcdata.abe.bapi.Yst_Htl_ChainType item) {
        return baseList().remove(item);
    }

}
