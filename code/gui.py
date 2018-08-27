import tkinter as tk
from parser import main

class Gui(tk.Tk):
    def __init__(self):
        super().__init__()

        self.title("Circuit drawing DSL")
        self.geometry("900x800")

        self.input_text = tk.Text(self, height = 40, width = 40, bg = "white", fg = "black")
        self.input_text.pack(side = tk.LEFT, fill = tk.X)
        self.input_text.focus_set()

        self.render_button = tk.Button(text = "Render", command = self.render, width = 200)
        self.render_button.pack(side = tk.BOTTOM)

        self.image = tk.PhotoImage(file = "output.png")
        self.output_image = tk.Label(self,image = self.image)
        self.output_image.pack(side = tk.RIGHT)

    
    def render(self):
        input_string = self.input_text.get(1.0,tk.END)
        main(input_string)


if __name__ == "__main__":
    gui = Gui()
    gui.mainloop()
