package simpleTasks.Products;

public interface Eatable {
    // TODO: 4/8/20 да этот более правильный интерфейс отвечает на вопрос не что делать(Eat) а что делающий или какой в данном случае, поскольку это интерфейс маркер
    //  но лучше чтобы интерфейс все же выделял деятельную часть, а не просто свойство. Возьмем для примера Eater интерфейс может быть примене как Animal так и Person
    //  и мы уже сможем прописать в каждом из них поведение, поскольку животное и человек едят по разному ;) но у обоих будет универсальный контракт(если ты не забыла терминологию)
}
