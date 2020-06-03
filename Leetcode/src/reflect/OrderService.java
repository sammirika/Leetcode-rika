package reflect;

import java.util.UUID;

public interface OrderService {

    public void save(UUID orderId, String name);

    public void update(UUID orderId, String name);

    public String getByName(String name);

}
