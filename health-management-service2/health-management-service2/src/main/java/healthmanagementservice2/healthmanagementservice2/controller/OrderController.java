package healthmanagementservice2.healthmanagementservice2.controller;


import healthmanagementservice2.healthmanagementservice2.Login.SessionConst;
import healthmanagementservice2.healthmanagementservice2.domain.Item;
import healthmanagementservice2.healthmanagementservice2.domain.Member;
import healthmanagementservice2.healthmanagementservice2.domain.Order;
import healthmanagementservice2.healthmanagementservice2.service.ItemService;
import healthmanagementservice2.healthmanagementservice2.service.MemberService;
import healthmanagementservice2.healthmanagementservice2.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/add")
    public String createForm(Model model){
        List<Item> items = itemService.findItems();
        model.addAttribute("items",items);
        return "orders/orderForm";
    }

    @PostMapping("/add")
    public String create(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)
                                     Member loginmember, @RequestParam Long itemId,@RequestParam("count") int count){
        orderService.order(loginmember.getId(), itemId,count);
        return "redirect:/";
    }
    @GetMapping
    public String orderList(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)
                                        Member loginmember, Model model){
        List<Order> orders=orderService.findAll(loginmember.getId());
        model.addAttribute("orders",orders);
        return "orders/orderList";
    }
    @PostMapping(value = "/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}
