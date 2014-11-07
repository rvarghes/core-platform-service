package com.kcdata.abe.bapi.util;
public class Yst_Bapi_Ins_ItemsType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 594006599L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BAPI_INS_ITEMS", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType.class, new com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType(), new java.lang.String[][]{}, 576, 1132, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BAPI_INS_ITEMS\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">BAPI AVOK Insurance  Items</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>576</ifr:internalLength1><ifr:internalLength2>1132</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Bapi_Ins_ItemsType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType removeYst_Bapi_Ins_ItemsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType)baseList().remove(index);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType setYst_Bapi_Ins_ItemsType(int index, com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType item) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType)baseList().set(index, item);
    }

    public void addYst_Bapi_Ins_ItemsType(int index, com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType item) {
        baseList().add(index, item);
    }

    public void addAllYst_Bapi_Ins_ItemsType(Yst_Bapi_Ins_ItemsType_List item) {
        baseList().addAll(item);
    }

    public boolean removeYst_Bapi_Ins_ItemsType(com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYst_Bapi_Ins_ItemsType(Yst_Bapi_Ins_ItemsType_List item) {
        return baseList().containsAll(item);
    }

    public void addYst_Bapi_Ins_ItemsType(com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType item) {
        baseList().add(item);
    }

    public void addAllYst_Bapi_Ins_ItemsType(int index, Yst_Bapi_Ins_ItemsType_List item) {
        baseList().addAll(index, item);
    }

    public boolean containsYst_Bapi_Ins_ItemsType(com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType getYst_Bapi_Ins_ItemsType(int index) {
        return (com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType)baseList().get(index);
    }

    public int lastIndexOfYst_Bapi_Ins_ItemsType(com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType item) {
        return baseList().lastIndexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType[] toArrayYst_Bapi_Ins_ItemsType() {
        return (com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType[] {});
    }

    public Yst_Bapi_Ins_ItemsType_List subListYst_Bapi_Ins_ItemsType(int fromIndex, int toIndex) {
        return (Yst_Bapi_Ins_ItemsType_List)baseList().subList(fromIndex, toIndex);
    }

    public int indexOfYst_Bapi_Ins_ItemsType(com.kcdata.abe.bapi.Yst_Bapi_Ins_ItemsType item) {
        return baseList().indexOf(item);
    }

}
