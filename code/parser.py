from lark import Lark, Transformer, Tree
from line import *
from circuit import *
from element import *
from TreeTransformer import *

def main(input_text):

    grammar = open('grammar.txt','r').read()

    parser = Lark(grammar, start = "expression")

    #parse
    parse_tree = parser.parse(input_text)

    #print the parse tree in the terminal
    #print(parse_tree.pretty())
    #print(parse_tree)

    def process_tree(tree):
        """
            new_parse_tree
            /    |    \
            /     |     \
        ele     ele   proc

        """
        c = circuit()
        l = line()
        names = {}
        procedures = []
        for lst in tree.children:
            print(lst)
            if type(lst[0]) is str:
                names[lst[0]] = lst[1]
            else:
                procedures.append(lst)
        print(names)
        #print(procedures)

        for proc in procedures:

            proc_elements_names = proc[0]
            proc_name = proc[1]

            #print(proc_elements_names)
            #print(proc_name)

            if proc_name == "set_mode":
                mode_name = proc_elements_names[0]
                if mode_name != "draw-mode": 
                    c.set_mode(mode_name)
                elif mode_name == "draw-mode":
                    l1 = line()
                    # draw mode is different from other modes
                    for element in names:
                        e = CompleteElement(element)
                        e.set_other_attrs(names[element])
                        e.process_other_attrs()
                        l1.addElement(e)
                    c.connectInSeries(l1)
                    c.set_mode("draw-mode")
                        
                        
            if proc_name == "series":
                l1 = line()
                for element in proc_elements_names:
                    l1.addElement(names[element])
                l = l1
                c.connectInSeries(l)
                        #raise SyntaxError("Alias {0} referrenced before assignment".format(item[0]))

            elif proc_name == "parallel":
                l1 = line()
                for element in proc_elements_names:
                    l1.addElement(names[element])
                    c.connectInParallel(l1)
                    l1 = line()


            elif proc_name == "add_parallel":
                new_element = proc_elements_names[1]
                old_element = proc_elements_names[0]
                l1 = line()
                l1.addElement(names[new_element])
                c.connection.append(l1)


            elif proc_name == "add_series":
                new_element = proc_elements_names[1]
                old_element = proc_elements_names[0]
                for ln in c.connection:
                    for e in ln.elements:
                        if names[old_element] == e:
                            ln.addElement(names[new_element])


        c.evaluate("output.png")
        #print(c)
    new_tree = TreeTransformer().transform(parse_tree)

    #print(new_tree.pretty())

    process_tree(new_tree)

if __name__ == "__main__":
    input_text = open("input.txt",'r').read()
    main(input_text)
