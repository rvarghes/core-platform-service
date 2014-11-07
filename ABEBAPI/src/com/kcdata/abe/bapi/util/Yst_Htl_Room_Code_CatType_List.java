package com.kcdata.abe.bapi.util;
public class Yst_Htl_Room_Code_CatType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = -1039577890L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_HTL_ROOM_CODE_CAT", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType.class, new com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType(), new java.lang.String[][]{}, 12, 24, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_HTL_ROOM_CODE_CAT\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Hotel room code &amp; category</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>300</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>12</ifr:internalLength1><ifr:internalLength2>24</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Htl_Room_Code_CatType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType[] toArrayYst_Htl_Room_Code_CatType() {
        return (com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType[] {});
    }

    public boolean removeYst_Htl_Room_Code_CatType(com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType item) {
        return baseList().remove(item);
    }

    public boolean containsAllYst_Htl_Room_Code_CatType(Yst_Htl_Room_Code_CatType_List item) {
        return baseList().containsAll(item);
    }

    public boolean containsYst_Htl_Room_Code_CatType(com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType getYst_Htl_Room_Code_CatType(int index) {
        return (com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType)baseList().get(index);
    }

    public com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType removeYst_Htl_Room_Code_CatType(int index) {
        return (com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType)baseList().remove(index);
    }

    public void addAllYst_Htl_Room_Code_CatType(int index, Yst_Htl_Room_Code_CatType_List item) {
        baseList().addAll(index, item);
    }

    public void addYst_Htl_Room_Code_CatType(com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType item) {
        baseList().add(item);
    }

    public int indexOfYst_Htl_Room_Code_CatType(com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType item) {
        return baseList().indexOf(item);
    }

    public void addAllYst_Htl_Room_Code_CatType(Yst_Htl_Room_Code_CatType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType setYst_Htl_Room_Code_CatType(int index, com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType item) {
        return (com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType)baseList().set(index, item);
    }

    public int lastIndexOfYst_Htl_Room_Code_CatType(com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType item) {
        return baseList().lastIndexOf(item);
    }

    public Yst_Htl_Room_Code_CatType_List subListYst_Htl_Room_Code_CatType(int fromIndex, int toIndex) {
        return (Yst_Htl_Room_Code_CatType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addYst_Htl_Room_Code_CatType(int index, com.kcdata.abe.bapi.Yst_Htl_Room_Code_CatType item) {
        baseList().add(index, item);
    }

}
