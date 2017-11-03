# AndroidViewSelector
Uma classe para selecionar views especificas em um layout em android.
## Exemplos
* formato exemplo:

``` 
[LinearLayout]
    [LinearLayout]
        [TextView android:text="1"/]
    [/LinearLayout]
    [LinearLayout]
        [TextView android:text="2"/]
        [LinearLayout]
            [TextView android:text="3"/]
            [FrameLayout]
                [Button android:text="4"/]
            [/FrameLayout]
        [/LinearLayout]
    [/LinearLayout]
    [FrameLayout]
        [TextView android:text="5"/]
    [/FrameLayout]
    [TextView android:text="6"/]
    [TextView android:text="7"/]
    [FrameLayout]
        [LinearLayout]
            [FrameLayout]
                [LinearLayout]
                    [Button android:text="8"/]
                [/LinearLayout]
            [/FrameLayout]
        [/LinearLayout]
    [/FrameLayout]
[/LinearLayout] 
```
* Exemplo 1:
Selecionar filhos diretos de um pai. Isso irá selecionar os TextViews que estão diretamente dentro do layout, no caso somente os textviews 6 e 7. 
```
Selector seletor = new Selector();
List<View> views = seletor  .findNearByClass(layout, AppCompatTextView.class)
                            .getViews();
pintarViews(views);
```
* Exemplo 2:
Selecionar filhos diretos e não diretos de um pai. Isso irá retornar todos os textviews que existem dentro do layout, no caso os textviwes 1,2,3,5,6,7.
```
Selector seletor = new Selector();
List<View> views = seletor  .findFarByClass(layout, AppCompatTextView.class)
                            .getViews();
pintarViews(views);
```

* Exemplo 3:
  * Selecionar filhos diretos aninhando finders. Isso irá retornar todos os Textviews que são filhos diretos de LinearLayouts que são filhos diretos do layout, no caso os textviews 1 e 2
    ```
    Selector seletor = new Selector();
    List<View> views = seletor  .findNearByClass(layout, LinearLayout.class)
                                .findNearByClass(AppCompatTextView.class)
                                .getViews();
    pintarViews(views);
    ```
  * Outro exemplo de aninhamento. Nesse caso será pegue o button 4.
    ```
    Selector seletor = new Selector();
    List<View> views = seletor  .findNearByClass(layout, LinearLayout.class)
                                .findNearByClass(LinearLayout.class)
                                .findNearByClass(FrameLayout.class)
                                .findNearByClass(AppCompatButton.class)
                                .getViews();
    pintarViews(views);
    ```
* Exemplo 4 :
Selecionar filhos indiretos aninhando finders. Nesse caso serão pegues todos os LinearLayouts que têm outro LinearLayout em qualquer subnó. No caso serão pegos o linearlayout que contém o textview 3 e o botao 4, e o linearlayout que contém o botão 8. 
```
Selector seletor = new Selector();
List<View> views = seletor  .findFarByClass(layout, LinearLayout.class)
                            .findFarByClass(LinearLayout.class)
                            .getViews();
pintarViews(views);
```

* Exemplo 5:
Selecionar filhos indiretos aninhando finders. Nesse caso serão selecionados quaisquer linearlayouts que contenham outro linearlayout diretamente. Nesse caso será somente o linearlayout que tem o textivew 3 e o botao 4.
```
Selector seletor = new Selector();
List<View> views = seletor  .findFarByClass(layout, LinearLayout.class)
                            .findNearByClass(LinearLayout.class)
                            .getViews();
pintarViews(views);
```
