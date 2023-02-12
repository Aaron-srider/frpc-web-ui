package fit.wenchao.frpcwebui.model;

import java.util.Objects;

import fit.wenchao.frpcwebui.constants.ResponseCode;

public class JsonResponse {

    ResponseCode code;
    Object data;

    public JsonResponse() {
    }

    public JsonResponse(ResponseCode code, Object data) {
        this.data = data;
        this.code = code;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseCode getCode() {
        return this.code;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }

    public JsonResponse data(Object data) {
        setData(data);
        return this;
    }

    public JsonResponse code(ResponseCode code) {
        setCode(code);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JsonResponse)) {
            return false;
        }
        JsonResponse jsonResponse = (JsonResponse) o;
        return Objects.equals(data, jsonResponse.data) && Objects.equals(code, jsonResponse.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, code);
    }

    @Override
    public String toString() {
        return "{" +
                " data='" + getData() + "'" +
                ", code='" + getCode() + "'" +
                "}";
    }

}
