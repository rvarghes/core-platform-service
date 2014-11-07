package com.kcdata.abe.bapi.util;
public class Yst_Htl_DataType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -925138328L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_HTL_DATA", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Htl_DataType.class, new com.kcdata.abe.bapi.Yst_Htl_DataType(), new java.lang.String[][]{}, 138, 276, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_HTL_DATA\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Hotel info</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>138</ifr:internalLength1><ifr:internalLength2>276</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Htl_DataType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public void addYst_Htl_DataType(int index, com.kcdata.abe.bapi.Yst_Htl_DataType item) {
        baseList().add(index, item);
    }

    public void addYst_Htl_DataType(com.kcdata.abe.bapi.Yst_Htl_DataType item) {
        baseList().add(item);
    }

    public boolean removeYst_Htl_DataType(com.kcdata.abe.bapi.Yst_Htl_DataType item) {
        return baseList().remove(item);
    }

    public Yst_Htl_DataType_List subListYst_Htl_DataType(int fromIndex, int toIndex) {
        return (Yst_Htl_DataType_List)baseList().subList(fromIndex, toIndex);
    }

    public boolean containsYst_Htl_DataType(com.kcdata.abe.bapi.Yst_Htl_DataType item) {
        return baseList().contains(item);
    }

    public void addAllYst_Htl_DataType(Yst_Htl_DataType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_DataType setYst_Htl_DataType(int index, com.kcdata.abe.bapi.Yst_Htl_DataType item) {
        return (com.kcdata.abe.bapi.Yst_Htl_DataType)baseList().set(index, item);
    }

    public boolean containsAllYst_Htl_DataType(Yst_Htl_DataType_List item) {
        return baseList().containsAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_DataType[] toArrayYst_Htl_DataType() {
        return (com.kcdata.abe.bapi.Yst_Htl_DataType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Htl_DataType[] {});
    }

    public com.kcdata.abe.bapi.Yst_Htl_DataType getYst_Htl_DataType(int index) {
        return (com.kcdata.abe.bapi.Yst_Htl_DataType)baseList().get(index);
    }

    public int indexOfYst_Htl_DataType(com.kcdata.abe.bapi.Yst_Htl_DataType item) {
        return baseList().indexOf(item);
    }

    public void addAllYst_Htl_DataType(int index, Yst_Htl_DataType_List item) {
        baseList().addAll(index, item);
    }

    public int lastIndexOfYst_Htl_DataType(com.kcdata.abe.bapi.Yst_Htl_DataType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_DataType removeYst_Htl_DataType(int index) {
        return (com.kcdata.abe.bapi.Yst_Htl_DataType)baseList().remove(index);
    }

}
