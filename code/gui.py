import tkinter as tk
from tkinter import filedialog
import tkinter.messagebox as msg
import configparser as cp
import ntpath

class Gui(tk.Tk):
    def __init__(self):
        super().__init__()

        self.title("Circuit drawing DSL")
        self.geometry("350x420")

        self.active_text = ""
        self.active_text_filename = ""
        self.text_elements = {}

        self.menubar = tk.Menu(self, bg="lightgrey", fg="black")
        self.file_menu = tk.Menu(self.menubar, tearoff=0, bg="lightgrey", fg="black") 
        self.file_menu.add_command(label="Open", command=self.file_open, accelerator="Ctrl+O")
        self.file_menu.add_command(label="Save", command=self.file_save, accelerator="Ctrl+S")
        self.menubar.add_cascade(label="File", menu=self.file_menu)

        self.config(menu=self.menubar)

        self.upper_label1 = tk.Label(self, text = "Welcome to Circuit-Drawing DSL!")
        self.upper_label1.pack(side = tk.TOP)

        self.upper_label2 = tk.Label(self, text = "Input left, output right.")
        self.upper_label2.pack(side = tk.TOP)

        self.render_button = tk.Button(text = "Render", command = self.render, width = 200)
        self.render_button.pack(side = tk.BOTTOM)

        self.input_text = tk.Text(self, height = 19, width = 20, bg = "white", fg = "black", font = "10")
        self.input_text.pack(side = tk.LEFT, fill = tk.X)
        self.input_text.focus_set()

        self.image = tk.PhotoImage(file = "output.png")
        self.output_image = tk.Label(self,image = self.image)
        self.output_image.pack(side = tk.RIGHT)

    
    def render(self):
        input_string = self.input_text.get(1.0,tk.END)
        from parser import main
        main(input_string)
        self.image = tk.PhotoImage(file = "output.png")
        self.output_image = tk.Label(self,image = self.image)

    def file_open(self, event=None):
        text_file = filedialog.askopenfilename()

        while text_file and not text_file.endswith(".txt"):
            msg.showerror("Wrong Filetype", "Please select an txt file")
            text_file = filedialog.askopenfilename()

        if text_file:
            self.parse_text_file(text_file)

    def file_save(self, event=None):
        if not self.active_text:
            msg.showerror("No File Open", "Please open an txt file first")
            return

        for section in self.active_text:
            for key in self.active_text[section]:
                try:
                    self.active_text[section][key] = self.text_elements[section][key].get()
                except KeyError:
                    # wasn't changed, no need to save it
                    pass

        with open(self.active_text_filename, "w") as text_file:
            self.active_text.write(text_file)

        msg.showinfo("Saved", "File Saved Successfully")

    def parse_text_file(self, text_file):
        pass
    
if __name__ == "__main__":
    gui = Gui()
    gui.mainloop()
