import tkinter as tk

class Gui(tk.Tk):
    def __init__(self):
        super().__init__()

        self.title("Circuit drawing DSL")
        self.geometry("350x420")

        self.upper_label1 = tk.Label(self, text = "Welcome to Circuit-Drawing DSL!")
        self.upper_label1.pack(side = tk.TOP)

        self.upper_label2 = tk.Label(self, text = "Input left, output right.")
        self.upper_label2.pack(side = tk.TOP)

        self.input_text = tk.Text(self, height = 19, width = 20, bg = "white", fg = "black", font = "10")
        self.input_text.pack(side = tk.LEFT, fill = tk.X)
        self.input_text.focus_set()

        self.render_button = tk.Button(text = "Render", command = self.render, width = 200)
        self.render_button.pack(side = tk.BOTTOM)

        self.image = tk.PhotoImage(file = "output.png")
        self.output_image = tk.Label(self,image = self.image)
        self.output_image.pack(side = tk.RIGHT)

    
    def render(self):
        input_string = self.input_text.get(1.0,tk.END)
        from parser import main
        main(input_string)

    
    
if __name__ == "__main__":
    gui = Gui()
    gui.mainloop()
