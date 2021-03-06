package com.example.controller;

import com.example.jpa.Item;
import com.example.jpa.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> findItem(){
        return itemRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item addItem(@RequestBody Item item){
        item.setId(null);
        return itemRepository.saveAndFlush(item);
    }

    @RequestMapping(value ="{/id}",method = RequestMethod.PUT)
    public Item updateItem(@RequestBody Item updateItem,@PathVariable Integer id){
        updateItem.setId(id);
        return itemRepository.saveAndFlush(updateItem);
    }

    @RequestMapping(value ="{/id}",method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable Integer id){
        itemRepository.delete(id);
    }
}
