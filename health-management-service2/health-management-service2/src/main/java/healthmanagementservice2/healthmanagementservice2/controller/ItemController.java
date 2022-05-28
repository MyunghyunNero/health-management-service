package healthmanagementservice2.healthmanagementservice2.controller;


import healthmanagementservice2.healthmanagementservice2.domain.Item;
import healthmanagementservice2.healthmanagementservice2.domain.form.ItemForm;
import healthmanagementservice2.healthmanagementservice2.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/new")
    public String creatForm(Model model){
        model.addAttribute("form",new ItemForm());
        return "items/createItemForm";
    }
    @PostMapping("/new")
    public String create(@Valid @ModelAttribute("form") ItemForm itemForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "items/createItemForm"; //검증은 나중에
        }
        Item item= new Item();
        item.setName(itemForm.getName());
        item.setPrice(itemForm.getPrice());
        item.setStockQuantity(itemForm.getStockQuantity());
        itemService.saveItem(item);
        return "redirect:/";
    }
    @GetMapping
    public String list(Model model){
        List<Item> items= itemService.findItems();
        model.addAttribute("items",items);
        return "items/itemList";
    }
    @GetMapping("/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId ,Model model){
        Item item=itemService.findOne(itemId);
        ItemForm itemForm=new ItemForm();
        itemForm.setId(item.getId());
        itemForm.setName(item.getName());
        itemForm.setPrice(item.getPrice());
        itemForm.setStockQuantity(item.getStockQuantity());
        model.addAttribute("form",itemForm);
        return "/items/updateItemForm";
    }
    @PostMapping("/{itemId}/edit")
    public String updateItem(@Valid @ModelAttribute("form") ItemForm form,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "items/updateItemForm"; //검증은 나중에
        }
        itemService.updateItem(form.getId(),form.getName(), form.getPrice(), form.getStockQuantity());
        return "redirect:/items";
    }
}
