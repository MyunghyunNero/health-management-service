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
import org.springframework.validation.BindingResult;
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
        model.addAttribute("item2",new Item());

        return "orders/orderForm";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute("item2") Item item,BindingResult bindingResult,@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)
                                     Member loginmember, @RequestParam Long itemId, @RequestParam("count") int count,Model model){
        Item item1=itemService.findOne(itemId);
        if(item1.getStockQuantity()<count){
            List<Item> items = itemService.findItems();
            model.addAttribute("items",items);
            bindingResult.rejectValue("stockQuantity","range", new Object[]{},"재고가 없습니다 현재 재고="+item1.getStockQuantity());
            return "orders/orderForm";
        }
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
