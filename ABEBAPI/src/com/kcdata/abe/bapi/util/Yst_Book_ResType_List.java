package com.kcdata.abe.bapi.util;
public class Yst_Book_ResType_List extends com.sap.aii.proxy.framework.core.AbstractList implements java.io.Serializable, java.util.List {

    private  static final long serialVersionUID = 1156768841L ;

    private  static final com.sap.aii.proxy.framework.core.XsdlElementProperties staticElementProperties = createElementProperties("item", null, null, "unqualified", "urn:sap-com:document:sap:rfc:functions:YST_BOOK_RES", "urn:sap-com:document:sap:rfc:functions", false, 0, -1, false, null, "Item", com.kcdata.abe.bapi.Yst_Book_ResType.class, new com.kcdata.abe.bapi.Yst_Book_ResType(), new java.lang.String[][]{}, 253, 500, -1, com.sap.mw.jco.JCO.TYPE_STRUCTURE, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<s0:type name=\"YST_BOOK_RES\" xmlns:s0=\"urn:sap-com:document:sap:rfc:functions\"><ifr:container xmlns:ifr=\"urn:sap-com:ifr:v2:metamodel\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"><ifr:descriptor><ifr:description language=\"EN\">Orders Search Results</ifr:description></ifr:descriptor><ifr:properties><ifr:sourceSystem /><ifr:sourceClient>130</ifr:sourceClient><ifr:release>700 </ifr:release><ifr:category>structure</ifr:category><ifr:unicode1>true</ifr:unicode1><ifr:unicode2>true</ifr:unicode2><ifr:isFlatStructure>true</ifr:isFlatStructure></ifr:properties><ifr:definition><ifr:internalLength1>253</ifr:internalLength1><ifr:internalLength2>500</ifr:internalLength2></ifr:definition></ifr:container></s0:type>") ;

    public  Yst_Book_ResType_List () {
        super(staticElementProperties, com.sap.aii.proxy.framework.core.FactoryConstants.CONNECTION_TYPE_JCO);
        
    }

    public int indexOfYst_Book_ResType(com.kcdata.abe.bapi.Yst_Book_ResType item) {
        return baseList().indexOf(item);
    }

    public com.kcdata.abe.bapi.Yst_Book_ResType removeYst_Book_ResType(int index) {
        return (com.kcdata.abe.bapi.Yst_Book_ResType)baseList().remove(index);
    }

    public void addYst_Book_ResType(int index, com.kcdata.abe.bapi.Yst_Book_ResType item) {
        baseList().add(index, item);
    }

    public boolean containsAllYst_Book_ResType(Yst_Book_ResType_List item) {
        return baseList().containsAll(item);
    }

    public boolean containsYst_Book_ResType(com.kcdata.abe.bapi.Yst_Book_ResType item) {
        return baseList().contains(item);
    }

    public com.kcdata.abe.bapi.Yst_Book_ResType setYst_Book_ResType(int index, com.kcdata.abe.bapi.Yst_Book_ResType item) {
        return (com.kcdata.abe.bapi.Yst_Book_ResType)baseList().set(index, item);
    }

    public void addYst_Book_ResType(com.kcdata.abe.bapi.Yst_Book_ResType item) {
        baseList().add(item);
    }

    public void addAllYst_Book_ResType(int index, Yst_Book_ResType_List item) {
        baseList().addAll(index, item);
    }

    public com.kcdata.abe.bapi.Yst_Book_ResType[] toArrayYst_Book_ResType() {
        return (com.kcdata.abe.bapi.Yst_Book_ResType[])baseList().toArray(new com.kcdata.abe.bapi.Yst_Book_ResType[] {});
    }

    public int lastIndexOfYst_Book_ResType(com.kcdata.abe.bapi.Yst_Book_ResType item) {
        return baseList().lastIndexOf(item);
    }

    public Yst_Book_ResType_List subListYst_Book_ResType(int fromIndex, int toIndex) {
        return (Yst_Book_ResType_List)baseList().subList(fromIndex, toIndex);
    }

    public void addAllYst_Book_ResType(Yst_Book_ResType_List item) {
        baseList().addAll(item);
    }

    public com.kcdata.abe.bapi.Yst_Book_ResType getYst_Book_ResType(int index) {
        return (com.kcdata.abe.bapi.Yst_Book_ResType)baseList().get(index);
    }

    public boolean removeYst_Book_ResType(com.kcdata.abe.bapi.Yst_Book_ResType item) {
        return baseList().remove(item);
    }

}
