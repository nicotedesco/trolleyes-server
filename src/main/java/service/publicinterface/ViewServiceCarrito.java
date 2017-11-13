package service.publicinterface;

import bean.ReplyBean;




public interface ViewServiceCarrito {

    public ReplyBean list() throws Exception;

    public ReplyBean buy() throws Exception;

    public ReplyBean empty() throws Exception;
}
