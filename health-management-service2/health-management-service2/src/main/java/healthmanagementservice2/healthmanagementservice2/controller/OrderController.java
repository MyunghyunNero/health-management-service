package healthmanagementservice2.healthmanagementservice2.controller;


import healthmanagementservice2.healthmanagementservice2.service.ItemService;
import healthmanagementservice2.healthmanagementservice2.service.MemberService;
import healthmanagementservice2.healthmanagementservice2.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;
}
