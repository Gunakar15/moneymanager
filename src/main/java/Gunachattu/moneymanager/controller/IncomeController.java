package Gunachattu.moneymanager.controller;


import Gunachattu.moneymanager.dto.ExpenseDTO;
import Gunachattu.moneymanager.dto.IncomeDTO;
import Gunachattu.moneymanager.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/incomes")
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping
    public ResponseEntity<IncomeDTO> addExpense(@RequestBody IncomeDTO dto) {
        System.out.println("helooo world !!!");
        IncomeDTO saved = incomeService.addIncome(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/getdemo")
    public String getDemo() {
        System.out.println("i am form there where ur not getting any thing !!!!");
        return "This is a demo endpoint for IncomeController";
    }
    @GetMapping
    public ResponseEntity<List<IncomeDTO>> getExpenses() {

        List<IncomeDTO> expenses = incomeService.getCurrentMonthIncomesForCurrentUser();
        return  ResponseEntity.ok(expenses);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
    }
}
